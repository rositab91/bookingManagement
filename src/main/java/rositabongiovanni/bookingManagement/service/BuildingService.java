package rositabongiovanni.bookingManagement.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rositabongiovanni.bookingManagement.dao.BuildingDAO;
import rositabongiovanni.bookingManagement.entities.Building;


@Service
@Slf4j
public class BuildingService {

	@Autowired private BuildingDAO buildingDAO;
	
	@Autowired @Qualifier("FakeBuilding") private ObjectProvider<Building> fakeBuildingProvider;
	
	public void createFakeBuilding() {
		Building b = fakeBuildingProvider.getObject();
		saveBuilding(b);
	}
	
	public void saveBuilding(Building b) {
		buildingDAO.save(b);
		log.info("Building " + b.getName() + " added to database");
	}
	
	public Building findById(Long id) {
		return buildingDAO.findById(id).get();	
	}
	
	public List<Building> findAll() {
		return (List<Building>) buildingDAO.findAll();	
	}
}
