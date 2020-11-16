package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.ReceiptType.Type;

@Controller
public class ConfigController {

    @Autowired
    private ObjectMapper jsonMapper;

    /*
    * safnar saman upphæðum í útgjaldaflokka og skilar JSON streng
    * sem er á forminu: "útgjaldaflokkur: upphæð"
    * */
    private String writeReceipts(ArrayList<Receipt> receipts){
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
    public String overview(Model model){
        Calendar calendar = new GregorianCalendar();
        int[] months = {10, 10,  9,  9,  8,  8, 10, 11, 10, 11};
        int[] days =   {12, 13, 12, 12, 10, 10, 13, 12, 10, 11};
        ArrayList<Receipt> receipts = new ArrayList<Receipt>();
        for(int i = 0; i < 10; i++){
            calendar.set(2020, months[i], days[i],10,0);
            receipts.add(new Receipt(calendar.getTime(),
                    LocalTime.now(),
                    Type.MATARINNKAUP,
                    1000));
        }
        model.addAttribute("receipts", writeReceipts(receipts));
        return "overView";
    }

    @RequestMapping(value = "/comparison", method = RequestMethod.GET)
    public String comparison(Model model) {
        return "comparison";
    }
}
