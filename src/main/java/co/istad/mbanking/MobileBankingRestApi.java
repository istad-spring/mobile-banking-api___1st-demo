package co.istad.mbanking;

import co.istad.mbanking.api.auth.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class MobileBankingRestApi {

    public static void main(String[] args) {
        SpringApplication.run(MobileBankingRestApi.class, args);
    }

}
