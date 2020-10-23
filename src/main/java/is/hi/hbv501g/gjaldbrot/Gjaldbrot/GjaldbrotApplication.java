package is.hi.hbv501g.gjaldbrot.Gjaldbrot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EntityScan
@EnableJpaRepositories(basePackageClasses = is.hi.hbv501g.gjaldbrot.Gjaldbrot.Repositories.UserRepository.class)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class GjaldbrotApplication {
	public static void main(String[] args) {
		SpringApplication.run(GjaldbrotApplication.class, args);
	}

}
