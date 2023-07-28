package rositabongiovanni.bookingManagement.service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rositabongiovanni.bookingManagement.dao.BookingDAO;
import rositabongiovanni.bookingManagement.dao.StationDAO;
import rositabongiovanni.bookingManagement.entities.Booking;
import rositabongiovanni.bookingManagement.entities.Station;
import rositabongiovanni.bookingManagement.entities.User;

@Service
@Slf4j
public class BookingService {

	@Autowired
	private BookingDAO bookingDAO;
	@Autowired
	StationDAO stationDAO;

	@Autowired
	@Qualifier("bookingParam")
	private ObjectProvider<Booking> BookingProvider;

	public void createBooking(LocalDate bookingDate, Station station, User user) {
		if (bookingDate.isAfter(LocalDate.now())) {
			if (station.isFreeStation()) {
				Boolean bool = user.getReservations().stream().map(b -> b.getBookingDate())
						.collect(Collectors.toList()).contains(bookingDate);
				if (!bool) {
					Booking reserv = BookingProvider.getObject(bookingDate, station, user);
					reserv.setStation(station);
					reserv.setUser(user);
					reserv.setBookingDate(bookingDate);
					reserv.setBookingDeadline(bookingDate.plusDays(1));
					reserv.getStation().setFreeStation(false);
					saveBooking(reserv);
					stationDAO.save(reserv.getStation());
				} else {
					System.out.println("WE'RE SORRY, YOU ALREADY HAVE A CURRENT RESERVATION ON THIS DATE");
				}
			}
				else {
				System.out.println("WE'RE SORRY, THE STATION IS NOT AVAILABLE");
			}
		}
				else {
					System.out.println("WE'RE SORRY, WE CANNOT GO BACK IN TIME");
				}
			}

			public void saveBooking(Booking booking) {
				bookingDAO.save(booking);
				log.info("Booking added to database");
			}
		}