package msharma.integration;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }
}
