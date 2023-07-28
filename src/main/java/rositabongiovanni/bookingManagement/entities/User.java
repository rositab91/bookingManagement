package rositabongiovanni.bookingManagement.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	@Column(nullable = false, unique = true)
	private String userName;
	private String fullName;

	@Column(nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Booking> reservations;

	public User(String userName, String fullName, String email) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", + userName=" + userName + ", fullName=" + fullName + ", email=" + email
				+ ", reservations=" + reservations + "]";
	}
}
