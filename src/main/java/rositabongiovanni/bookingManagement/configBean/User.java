package rositabongiovanni.bookingManagement.configBean;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import rositabongiovanni.bookingManagement.entities.Station;

@Configuration
@PropertySource("classpath:application.properties")
public class User {

	@Bean
	@Scope("prototype")
	private User userCustom() {
		return new User();
	}
	
	@Bean
	@Scope("prototype")

	private User userParam(String userName, String fullName, String email) {
		return new User(userName, fullName, email);
	}

	@Bean("FakeUser")
	@Scope("prototype")
	
	private User fakeUser(Station station) {
		Faker fake = Faker.instance(new Locale("it-IT"));
		User u = new User();
		u.setFullName(fake.funnyName().name());
		u.setUserName(u.getFullName() + fake.idNumber());
		u.setEmail(u.getFullName() + "@example.com");
		return u;
	}
}