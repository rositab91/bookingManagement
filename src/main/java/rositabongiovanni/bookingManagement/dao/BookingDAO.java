package rositabongiovanni.bookingManagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rositabongiovanni.bookingManagement.entities.Booking;


@Repository
public interface BookingDAO extends CrudRepository<Booking, Long> {

}
