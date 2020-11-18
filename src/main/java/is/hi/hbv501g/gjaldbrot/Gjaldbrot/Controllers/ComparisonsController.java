package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.ReceiptService;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptType.Type;

import javax.servlet.http.HttpSession;

@Controller
public class ComparisonsController {
    private ReceiptService receiptService;
    private UserService userService;

    @Autowired
    public ComparisonsController(ReceiptService receiptService, UserService userService){
        this.receiptService = receiptService;
        this.userService = userService;
    }

    /*
    * safnar saman upphæðum í útgjaldaflokka og skilar JSON streng
    * sem er á forminu: "útgjaldaflokkur: upphæð"
    * */
    private String writeReceipts(List<Receipt> receipts){
        int matur = 0, fot=0, afengi=0, tobak=0, skemmtun=0, veitingar=0;
        for (Receipt r : receipts) {
            if (r.getType() == Type.MATARINNKAUP) matur += r.getAmount();
            else if (r.getType() == Type.FATNADUR) fot += r.getAmount();
            else if (r.getType() == Type.AFENGI) afengi += r.getAmount();
            else if (r.getType() == Type.TOBAK) tobak += r.getAmount();
            else if (r.getType() == Type.SKEMMTUN_OG_AFTREYING) skemmtun += r.getAmount();
            else if (r.getType() == Type.VEITINGASTADUR) veitingar += r.getAmount();
        }
        String JSON = String.format("{\"matur\":%d,\"fatnadur\":%d,\"afengi\":%d,\"tobak\":%d,\"skemmtun\":%d,\"veitingar\":%d}",
                matur,fot,afengi,tobak,skemmtun,veitingar);
        System.out.println(JSON);
        return JSON;
    }

    /*
    * Safnar saman upplýsingum fyrir samanburð milli mánuða í JSON streng
     */
    private String writeComparison(ArrayList<Receipt> r) {
        // þarf að vera einhver hella jank strengja aðferð held ég

        return "";
    }


    @RequestMapping(value = "/overView", method = RequestMethod.GET)
    public String overview(Model model, HttpSession session){
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        Date dateobj = new Date();

        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if (sessionUser != null) {
            User u = userService.getUserByName(sessionUser.getuName());

            List<Receipt> receipts = receiptService.getReceiptsByMonth(u, df.format(dateobj));
            model.addAttribute("receipts", writeReceipts(receipts));
            return "overView";
        }
        return "redirect:/";
    }

    private

    @RequestMapping(value = "/comparison", method = RequestMethod.GET)
    public String comparison(Model model, HttpSession session) {
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        Date dateobj = new Date();

        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if (sessionUser != null) {
            User u = userService.getUserByName(sessionUser.getuName());

            List<Receipt> receipts = receiptService.getReceipts(u);
            for(Receipt r : receipts) {
                System.out.println(r.getDate());
            }
            Collections.sort(receipts);
            return "comparison";
        }
        return "redirect:/";
    }
}
