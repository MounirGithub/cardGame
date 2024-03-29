package atexo.kata.cardGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("atexo.kata.cardGame")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CardGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardGeneratorApplication.class, args);
	}

}
