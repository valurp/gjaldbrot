package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Controllers;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.ReceiptService;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    public String compareGET(Model model){
        return "compare";
    }


    @RequestMapping(value="/deleteReceipt/{id}", method = RequestMethod.GET)
    public String deleteMovie(@PathVariable("id") long id, Model model){
        Receipt receipt = receiptService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Receipt ID"));
        receiptService.delete(receipt);
        model.addAttribute("movies", receiptService.findAll());
        return "getAllReceipts";
    }
}
