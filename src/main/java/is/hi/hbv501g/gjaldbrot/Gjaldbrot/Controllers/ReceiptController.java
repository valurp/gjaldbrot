package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Controllers;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.ReceiptService;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReceiptController {
    private ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService){
        this.receiptService = receiptService;
    }

    @RequestMapping(value = "/addReceipt", method = RequestMethod.GET)
    public String addreceiptGET(User user){
        return "addReceipt";
    }


    @RequestMapping(value = "/getAllReceipts", method = RequestMethod.GET)
    public String receiptsGet(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser != null){
            List<Receipt> receipts = receiptService.getReceipts(sessionUser);
            model.addAttribute("receipts", receipts);
            return "getAllReceipts";
        }
        return "redirect:/";
    }
}

