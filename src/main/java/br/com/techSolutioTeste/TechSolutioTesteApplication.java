package br.com.techSolutioTeste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.techSolutioTeste.Controllers")
public class TechSolutioTesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechSolutioTesteApplication.class, args);
	}

}
