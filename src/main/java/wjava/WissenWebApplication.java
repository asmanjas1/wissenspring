package wjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="wjava.repository")
@EntityScan(basePackages = "wjava.entity")
@SpringBootApplication
@EnableAutoConfiguration
public class WissenWebApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WissenWebApplication.class, args);
	}

}