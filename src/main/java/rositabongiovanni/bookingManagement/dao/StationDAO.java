package rositabongiovanni.bookingManagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rositabongiovanni.bookingManagement.entities.Station;

@Repository
public interface StationDAO extends CrudRepository<Station, Long> {

}
