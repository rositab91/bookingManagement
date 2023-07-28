package rositabongiovanni.bookingManagement.configBean;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import rositabongiovanni.bookingManagement.entities.Building;
import rositabongiovanni.bookingManagement.entities.Station;
import rositabongiovanni.bookingManagement.enum_.StationType;

@Configuration
@PropertySource("classpath:application.properties")

public class StationConfig {
	@Bean
	@Scope("prototype")
	public Station stationCustom() {
	return new Station();
}


@Bean
@Scope("prototype")
public Station stationParam(String description, StationType stationType, int maxOccupants, Building building, boolean FreeStation) {
	return new Station(description, stationType, maxOccupants, building, FreeStation);
}

@Bean("FakeStation")
@Scope("prototype")
public Station fakePostazione(Building building) {
	Faker fake = Faker.instance(new Locale("it-IT"));
	Station s = new Station();
	s.setDescription(fake.rockBand().name());
	int random = fake.number().numberBetween(2, 30);
	s.setMaxOccupants(random);
	if(random <10) {
		s.setStationType(StationType.PRIVATE);
	}else if(random <20) {
		s.setStationType(StationType.OPEN_SPACE);
	}else {
		s.setStationType(StationType.MEETING_ROOM);
	}
	s.setFreeStation(true);
	s.setBuilding(building);
	return s;
}
}
