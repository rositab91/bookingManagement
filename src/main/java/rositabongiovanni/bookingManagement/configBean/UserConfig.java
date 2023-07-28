package rositabongiovanni.bookingManagement.configBean;

import java.util.Locale;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import rositabongiovanni.bookingManagement.entities.Station;

@Configuration
@PropertySource("classpath:application.properties")
public class UserConfig {

	@Bean
	@Scope("prototype")
	public User customUser() {
		return new User();
	}
	
	@Bean
	@Scope("prototype")
	public User userParam(String userName, String fullName, String email) {
		return new User();
	}
	
	@Bean("UtenteFake")
	@Scope("prototype")
	public User fakeUser(Station station) {
		Faker fake = Faker.instance(new Locale("it-IT"));
	User u = new User();
	u.setName(fake.funnyName().name());
	u.setName(u.getName() + fake.idNumber());
	u.getEmail(u.getName() + "@example.com");
	return u;
	}
	
}
