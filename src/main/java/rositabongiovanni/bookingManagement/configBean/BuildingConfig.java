package rositabongiovanni.bookingManagement.configBean;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import rositabongiovanni.bookingManagement.entities.Building;

@Configuration
@PropertySource("classpath:application.properties")
public class BuildingConfig {

	@Bean
	@Scope("prototype")
	public Building buildingCustom() {
		return new Building();
	}

	@Bean("FakeBuilding")
	@Scope("prototype")
	public Building fakeBuilding() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Building b = new Building();
		b.setCity(fake.address().city());
		b.setAddress(fake.address().fullAddress());
		b.setName(fake.company().name());
		return b;
	}
}