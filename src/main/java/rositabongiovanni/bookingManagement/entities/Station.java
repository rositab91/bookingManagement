package rositabongiovanni.bookingManagement.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rositabongiovanni.bookingManagement.enum_.StationType;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stations")

public class Station implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStation;
	private String description;

	@Enumerated(EnumType.STRING)
	private StationType stationType;
	private int maxOccupants;

	@ManyToOne
	private Building building;
	private boolean FreeStation;

	public Station(String description, StationType stationType, int maxOccupants, Building building,
			boolean FreeStation) {
		super();
		this.description = description;
		this.stationType = stationType;
		this.maxOccupants = maxOccupants;
		this.building = building;
		this.FreeStation = FreeStation;
	}
}
