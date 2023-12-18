package map.project.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class beispiel {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
