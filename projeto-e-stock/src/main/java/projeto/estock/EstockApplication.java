package projeto.estock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EstockApplication {
	public static void main(String[] args) {
		SpringApplication.run(EstockApplication.class, args);
	}

}
