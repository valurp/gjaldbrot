package is.hi.hbv501g.gjaldbrot.Gjaldbrot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GjaldbrotApplication {

	public static void main(String[] args) {
		SpringApplication.run(GjaldbrotApplication.class, args);
	}
}
