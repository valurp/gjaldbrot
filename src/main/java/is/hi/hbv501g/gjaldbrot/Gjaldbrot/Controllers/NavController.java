package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class NavController {

    @RequestMapping(value = "/savings", method = RequestMethod.GET)
    public String savingsGET(Model model){
        return "savings";
    }

    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    public String compareGET(Model model){
        return "compare";
    }
}
