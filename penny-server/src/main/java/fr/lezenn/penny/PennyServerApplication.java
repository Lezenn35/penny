package fr.lezenn.penny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PennyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PennyServerApplication.class, args);
    }

}
