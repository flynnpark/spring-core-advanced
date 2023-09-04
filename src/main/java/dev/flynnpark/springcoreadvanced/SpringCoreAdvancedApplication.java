package dev.flynnpark.springcoreadvanced;

import dev.flynnpark.springcoreadvanced.config.AppV1Config;
import dev.flynnpark.springcoreadvanced.config.AppV2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "dev.flynnpark.springcoreadvanced.app.v1")
public class SpringCoreAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreAdvancedApplication.class, args);
	}

}
