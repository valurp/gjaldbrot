package is.hi.hbv501g.gjaldbrot.Gjaldbrot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String Home(){
        return "LoginPage";
    }

    @RequestMapping("/login")
    public String LoginPage(){
        return "LoginPage";
    }

    @RequestMapping("/register")
    public String RegisterPage(){
        return "RegisterPage";
    }

    @RequestMapping("/receipt")
    public String ReceiptPage(){
        return "ReceiptPage";
    }

    @RequestMapping("styles.css")
    public String CSS() {
        return "styles.css";
    }
}