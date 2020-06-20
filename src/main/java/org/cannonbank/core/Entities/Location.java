package org.cannonbank.core.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name="localtion")
public class Location implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer idLocation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;

	private float longitude;
	private float latitude;

	public Location() {
	}

	public Location(Agency agency, float longitude, float latitude) {
		this.agency = agency;
		this.longitude = longitude;
		this.latitude = latitude;
	}


}
