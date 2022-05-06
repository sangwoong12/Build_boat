package make.webpage.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class LoginController {

    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "main/index";
    }
}