package br.com.viniciusfinger.geofences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import org.n52.jackson.datatype.jts.JtsModule;

@SpringBootApplication
@EnableMethodSecurity(
		securedEnabled = true,
		jsr250Enabled = true
)
public class FencesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FencesApplication.class, args);
	}

	@Bean
	public JtsModule jtsModule() {
		return new JtsModule();
	}
}
