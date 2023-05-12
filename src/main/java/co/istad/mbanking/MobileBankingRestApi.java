package co.istad.mbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class MobileBankingRestApi {

    public static void main(String[] args) {
        SpringApplication.run(MobileBankingRestApi.class, args);
    }

    @GetMapping("/test")
    public String testVerifyView() {
        return "auth/verify";
    }

}
