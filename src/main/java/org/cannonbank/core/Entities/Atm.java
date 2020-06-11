package org.cannonbank.core.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor

@Entity

public class Atm implements java.io.Serializable {

	private Integer idAtm;
	private String address;
	private float longitude;
	private float latitude;

	public Atm() {
	}

	public Atm(String address, float longitude, float latitude) {
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_ATM", unique = true, nullable = false)
	public Integer getIdAtm() {
		return this.idAtm;
	}

	public void setIdAtm(Integer idAtm) {
		this.idAtm = idAtm;
	}

	@Column(name = "Address", nullable = false, length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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
