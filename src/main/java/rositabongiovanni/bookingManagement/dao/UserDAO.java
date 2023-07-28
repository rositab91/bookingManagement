package rositabongiovanni.bookingManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rositabongiovanni.bookingManagement.entities.Station;
import rositabongiovanni.bookingManagement.entities.User;
import rositabongiovanni.bookingManagement.enum_.StationType;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

	@Query(value = "SELECT s FROM Station s WHERE s.stationType = :type and s.building.city = :city")
	public List<Station> findByTypeAndCity(StationType type, String city);
}
