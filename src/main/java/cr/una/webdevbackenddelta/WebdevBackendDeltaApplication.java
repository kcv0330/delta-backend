package cr.una.webdevbackenddelta;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Properties;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class WebdevBackendDeltaApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WebdevBackendDeltaApplication.class);
		Properties props = new Properties();
		props.setProperty("server.port", "8083");
		app.setDefaultProperties(props);
		app.run(args);

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
