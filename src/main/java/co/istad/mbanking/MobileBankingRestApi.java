package co.istad.mbanking;

import co.istad.mbanking.api.auth.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class MobileBankingRestApi implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MobileBankingRestApi.class, args);
    }

    @GetMapping("/test")
    public String testVerifyView() {
        return "auth/verify";
    }

    @Autowired
    AuthMapper authMapper;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(authMapper.loadUserRoles(16));
    }
}
