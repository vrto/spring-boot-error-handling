package sk.vrto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringBootErrorHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootErrorHandlingApplication.class, args);
	}
}
