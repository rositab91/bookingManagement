package rositabongiovanni.bookingManagement.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "reservations")
public class Booking implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBooking;
	private LocalDate bookingDate;
	private LocalDate bookingDeadline;

	@ManyToOne
	private Station station;

	@ManyToOne
	private User user;

	public Booking(LocalDate bookingDate, Station station, User user) {
		super();
		this.bookingDate = bookingDate;
		this.station = station;
		this.user = user;
	}
	}

	/*
	 * public Booking(LocalDate bookingDate, Station station, User user) { super();
	 * this.bookingDate = bookingDate; this.station = station; this.user = user; }
	 */