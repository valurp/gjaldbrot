package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Controllers;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptHost;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptType;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.ReceiptService;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class ReceiptController {
    private ReceiptService receiptService;
    private UserService userService;

    /**
     * ReceiptController calls service that need to be used with entity receipt.
     * @param receiptService gets the receipt service class.
     * @param userService gets the user service class.
     */
    @Autowired
    public ReceiptController(ReceiptService receiptService, UserService userService){
        this.receiptService = receiptService;
        this.userService = userService;
    }

    /**
     * addReceiptGet gets the addReceipt.html file as a request from the DOM.
     * @param session This is the session that has been created by the user logging in.
     * @param model Model from the init of the user.
     * @param receipt Request of the receipt class from the entity receipt.
     * @return addReceipt.html view or redirects to the front page.
     */
    @RequestMapping(value = "/addReceipt", method = RequestMethod.GET)
    public String addReceiptGET(HttpSession session, Model model, ReceiptHost receipt){
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        model.addAttribute("receipt", receipt);
        if(sessionUser != null) {
            model.addAttribute("userId", sessionUser.getId());
            return "addReceipt";
        }
        return "redirect:/";
    }

    /**
     * addReceiptPost, post action of html, gets and stores data from addReceipt.html post action.
     * @param receipt Request of the receipt class from the entity receipt.
     * @param result Binding results from the post action of the addReceipt.html form(action=POST) (not used).
     * @param model Model from the init of the user (not used).
     * @param session This is the session that has been created by the user logging in.
     * @return view of the mainPage.html.
     */
    @RequestMapping(value = "/addReceipt", method = RequestMethod.POST)
    public String addReceiptPost(@Valid ReceiptHost receipt, BindingResult result, Model model, HttpSession session) throws Exception{
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        Receipt newReceipt = receipt.createReceipt();
        newReceipt.setUser(userService.getUserByName(sessionUser.getuName()));
        receiptService.add(newReceipt);
        return "mainPage";
    }

    /**
     *
     * @param session This is the session that has been created by the user logging in.
     * @param model Model from the init of the user.
     * @return getAllReceipts if there are logged in users or redirects to the front page.
     */
    @RequestMapping(value = "/allReceipts", method = RequestMethod.GET)
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

    @RequestMapping(value = "/changeReceipt/{id}", method = RequestMethod.GET)
    private String changeReceiptGET(@PathVariable("id") long id, Model model, ReceiptHost newReceipt, HttpSession session) {
        session.setAttribute("changedReceipt", receiptService.getReceiptById(id));
        model.addAttribute("newReceipt", newReceipt);
        Receipt r = receiptService.getReceiptById(id);
        model.addAttribute("oldReceiptType", ReceiptType.typeToInt(r.getType()));
        model.addAttribute("oldReceiptAmount", r.getAmount());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        model.addAttribute("oldReceiptDate", df.format(r.getDate()));

        return "changeReceipt";
    }

    @RequestMapping(value = "/changeReceipt", method = RequestMethod.POST)
    private String changeReceiptPOST(@Valid ReceiptHost newReceipt, BindingResult result, Model model, HttpSession session){
        Receipt oldReceipt = (Receipt) session.getAttribute("changedReceipt");
        receiptService.change(oldReceipt, newReceipt);
        return "redirect:/allReceipts";
    }

    @RequestMapping(value="/deleteReceipt/{id}", method = RequestMethod.GET)
    public String deleteReceipt(@PathVariable("id") long id, Model model){
        System.out.println("TestDelete");
        Receipt receipt = receiptService.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Receipt ID"));
        receiptService.delete(receipt);
        model.addAttribute("receipt", receiptService.findAll());
        return "redirect:/allReceipts";
    }

    @RequestMapping(value = "/savings", method = RequestMethod.GET)
    public String savingsGET(Model model){
        return "savings";
    }

}

