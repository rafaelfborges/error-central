package dev.codenation.errorcentral;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.SpringDocUtils;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@EnableJpaAuditing
@SpringBootApplication
public class ErrorCentralApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorCentralApplication.class, args);
	}

	@Bean
	public OpenAPI springEventLogOpenAPI() {
		SpringDocUtils.getConfig().replaceWithClass(org.springframework.data.domain.Pageable.class, Pageable.class);
		return new OpenAPI()
				.info(new Info().title("Error Central API").description("Error Central is a API for centralize event logs records for your app")
				.version("v1.0").license(new License().name("Apache	2.0").url("http://springdoc.org")))
				.components(new Components()
				.addSecuritySchemes("TOKEN",
								new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
										.in(SecurityScheme.In.HEADER).name("Authorization"))
				.addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))

				.addSecurityItem(new SecurityRequirement().addList("TOKEN", Arrays.asList("read", "write")));
	}
}
