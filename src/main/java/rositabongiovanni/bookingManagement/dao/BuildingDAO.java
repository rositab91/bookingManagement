package rositabongiovanni.bookingManagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rositabongiovanni.bookingManagement.entities.Building;

@Repository
public interface BuildingDAO extends CrudRepository<Building, Long> {

}
