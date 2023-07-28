package rositabongiovanni.bookingManagement.configBean;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import rositabongiovanni.bookingManagement.entities.Booking;
import rositabongiovanni.bookingManagement.entities.Station;
import rositabongiovanni.bookingManagement.entities.User;


@Configuration
@PropertySource("classpath:application.properties")
public class BookingConfig {

	@Bean
	@Scope("prototype")

	public Booking bookingCustom() {
		return new Booking();
	}
	
	@Bean("bookingParam")
	@Scope("prototype")

	public Booking bookingParam(LocalDate bookingDate, Station station, User user) {
		return new Booking(bookingDate, station, user);
	}
}