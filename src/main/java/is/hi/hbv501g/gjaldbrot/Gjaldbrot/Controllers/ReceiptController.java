package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Controllers;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.ReceiptService;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ReceiptController {
    private ReceiptService receiptService;
    private UserService userService;

    @Autowired
    public ReceiptController(ReceiptService receiptService, UserService userService){
        this.receiptService = receiptService;
        this.userService = userService;
    }

    @RequestMapping(value = "/addReceipt", method = RequestMethod.GET)
    public String addReceiptGET(HttpSession session, Model model, Receipt receipt){
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser != null) {
            model.addAttribute("userId", sessionUser.getId());
            return "addReceipt";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/addReceipt", method = RequestMethod.POST)
    public String addReceiptPost(@Valid Receipt receipt, BindingResult result, Model model, HttpSession session) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        receipt.setUser(userService.getUserByName(sessionUser.getuName()));
        receiptService.add(receipt);
        return "mainPage";
    }


    @RequestMapping(value = "/getAllReceipts", method = RequestMethod.GET)
    public String receiptsGet(HttpSession session, Model model) {
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        System.out.println(""+sessionUser);
        if(sessionUser != null){
            List<Receipt> receipts = receiptService.getReceipts(userService.getUserByName(sessionUser.getuName()));
            model.addAttribute("receipts", receipts);
            return "getAllReceipts";
        }
        return "redirect:/";
    }
}

