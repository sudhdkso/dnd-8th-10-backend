package dnd.dnd10_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Dnd10BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Dnd10BackendApplication.class, args);
    }

}
