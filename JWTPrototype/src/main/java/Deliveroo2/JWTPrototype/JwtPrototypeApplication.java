package Deliveroo2.JWTPrototype;

import Deliveroo2.JWTPrototype.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class JwtPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtPrototypeApplication.class, args);
	}

}
