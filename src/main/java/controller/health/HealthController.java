package controller.health;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public String checkAPI(){
        return "Metodo GET";
    }
       

}

