package br.com.techSolutioTeste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = "br.com.techSolutioTeste.Controllers")
public class TechSolutioTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechSolutioTesteApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("1234"));
	}

}
