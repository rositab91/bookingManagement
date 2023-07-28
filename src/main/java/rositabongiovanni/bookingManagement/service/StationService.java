package rositabongiovanni.bookingManagement.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rositabongiovanni.bookingManagement.dao.StationDAO;
import rositabongiovanni.bookingManagement.entities.Building;
import rositabongiovanni.bookingManagement.entities.Station;

@Service
@Slf4j
public class StationService {

	@Autowired
	private StationDAO stationDAO;

	@Autowired
	@Qualifier("FakeStation")
	private ObjectProvider<Station> fakeStationProvider;

	public void createFakeStation(Building building) {
		Station s = fakeStationProvider.getObject(building);
		s.setBuilding(building);
		saveStation(s);
	}

	public void saveStation(Station s) {
		stationDAO.save(s);
		log.info("Station " + s.getDescription() + " added to database");
	}

	public Station findById(Long id) {
		return stationDAO.findById(id).get();
	}

	public List<Station> findAll() {
		return (List<Station>) stationDAO.findAll();
	}
}
