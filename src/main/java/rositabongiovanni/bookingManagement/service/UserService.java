package rositabongiovanni.bookingManagement.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rositabongiovanni.bookingManagement.dao.UserDAO;
import rositabongiovanni.bookingManagement.entities.Station;
import rositabongiovanni.bookingManagement.entities.User;
import rositabongiovanni.bookingManagement.enum_.StationType;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	@Qualifier("FakeUser")
	private ObjectProvider<User> fakeUserProvider;

	public void createFakeUser(Station station) {
		User u = fakeUserProvider.getObject(station);
		saveUser(u);
	}

	public void saveUser(User u) {
		userDAO.save(u);
		log.info("User " + u.getEmail() + " added to database");
	}

	public User findById(Long id) {
		return userDAO.findById(id).get();
	}

	public List<User> findAll() {
		return (List<User>) userDAO.findAll();
	}

	public void findByTypeAndCity(StationType type, String city) {
		if (userDAO.findByTypeAndCity(type, city).isEmpty()) {
			System.out.println("ERROR: NO LOCATION FOUND IN THE CITY " + city + " OF TYPE " + type);
		}
		
		System.out.println("\n THE SEARCH OF THE CITY " + city + " OF TYPE " +  type + " HAS GIVEN THE FOLLOWING RESULTS \n" + userDAO.findByTypeAndCity(type, city)); 

	}
}
	