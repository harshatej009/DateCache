package harsh.rane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableJpaRepositories(basePackages = "harsh.rane.repository")
public class DataCacheMain {

	public static void main(String[] args)
	{
		SpringApplication.run(DataCacheMain.class, args);
	}
	
	
}
