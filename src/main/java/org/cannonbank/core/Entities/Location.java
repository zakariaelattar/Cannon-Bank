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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor

@Entity

public class Location implements java.io.Serializable {

	private Integer idLocation;
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

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_Location", unique = true, nullable = false)
	public Integer getIdLocation() {
		return this.idLocation;
	}

	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Agency", nullable = false)
	public Agency getAgency() {
		return this.agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	@Column(name = "Longitude", nullable = false, precision = 12, scale = 0)
	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Column(name = "Latitude", nullable = false, precision = 12, scale = 0)
	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

}
