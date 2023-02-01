package chat.app.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

    @RequestMapping("/")
    public String pong() {
        return "pong";
    }
}
