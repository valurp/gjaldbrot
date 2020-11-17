package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Controllers;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.ReceiptService;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavController {
    private ReceiptService receiptService;

    @Autowired
    public NavController(ReceiptService receiptService){
        this.receiptService = receiptService;
    }

    @RequestMapping(value = "/savings", method = RequestMethod.GET)
    public String savingsGET(Model model){
        return "savings";
    }


    @RequestMapping(value="/deleteReceipt/{id}", method = RequestMethod.GET)
    public String deleteReceipt(@PathVariable("id") long id, Model model){
        System.out.println("TestDelete");
        Receipt receipt = receiptService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Receipt ID"));
        receiptService.delete(receipt);
        model.addAttribute("receipt", receiptService.findAll());
        return "redirect:/allReceipts";
    }
}
