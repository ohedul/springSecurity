package bd.ohedulalam.springSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ApplicationController {
    @GetMapping("/process")
    public String processing(){
        return "processing.....";
    }
}
