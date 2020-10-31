package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {
    @RequestMapping("css/styles.css")
    public String CSS() {
        return "css/styles.css";
    }
}
