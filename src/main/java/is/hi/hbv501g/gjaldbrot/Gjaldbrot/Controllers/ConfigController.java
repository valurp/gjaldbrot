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

    @RequestMapping(value = "/overView", method = RequestMethod.GET)
    public String overview(Model model){
        Calendar calendar = new GregorianCalendar();
        int[] months = {10, 10,  9,  9,  8,  8, 10, 11, 10, 11};
        int[] days =   {12, 13, 12, 12, 10, 10, 13, 12, 10, 11};
        ArrayList<Receipt> receipts = new ArrayList<Receipt>();
        for(int i = 0; i < 10; i++){
            calendar.set(2020, months[i], days[i],0,0);
            receipts.add(new Receipt(calendar.getTime(),
                    LocalTime.now(),
                    Type.MATARINNKAUP,
                    1000));
        }

        String jsonReceipts;
        try {
            jsonReceipts = jsonMapper.writeValueAsString(receipts);
        }
        catch(Error | JsonProcessingException e){
            jsonReceipts="";
            System.out.println("got error on parsing");
        }
        model.addAttribute("receipts", jsonReceipts);
        return "overView";
    }
}
