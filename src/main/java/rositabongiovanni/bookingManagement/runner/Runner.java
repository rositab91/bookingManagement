package rositabongiovanni.bookingManagement.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import rositabongiovanni.bookingManagement.enum_.StationType;
import rositabongiovanni.bookingManagement.service.BookingService;
import rositabongiovanni.bookingManagement.service.BuildingService;
import rositabongiovanni.bookingManagement.service.StationService;
import rositabongiovanni.bookingManagement.service.UserService;

public class Runner implements ApplicationRunner {

	@Autowired
	UserService userDAO;
	@Autowired
	BuildingService buildingDAO;
	@Autowired
	StationService stationDAO;
	@Autowired
	BookingService bookingDAO;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		buildingDAO.createFakeBuilding();
		buildingDAO.createFakeBuilding();

		stationDAO.createFakeStation(buildingDAO.findById(1l));
		stationDAO.createFakeStation(buildingDAO.findById(2l));

		userDAO.createFakeUser(stationDAO.findById(1l));
		userDAO.createFakeUser(stationDAO.findById(2l));

		bookingDAO.createBooking(LocalDate.of(2023, 7, 28), stationDAO.findById(1l), userDAO.findById(1l));
		bookingDAO.createBooking(LocalDate.of(2020, 3, 26), stationDAO.findById(1l), userDAO.findById(1l));
		bookingDAO.createBooking(LocalDate.of(2016, 10, 22), stationDAO.findById(1l), userDAO.findById(1l));

		
		userDAO.findByTypeAndCity(StationType.OPEN_SPACE, "Urban Office Belval");
	}
}
