package org.cannonbank.core.Entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor

@Entity

public class Agency implements java.io.Serializable {

	private Integer idAgency;
	private String name;
	private String address;
	private String country;
	private String email;
	private String phone;
	private String fax;
	private Set<Banker> bankers = new HashSet<Banker>(0);
	private Set<Location> locations = new HashSet<Location>(0);

	public Agency() {
	}

	public Agency(String name, String address, String country, String email, String phone, String fax) {
		this.name = name;
		this.address = address;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.fax = fax;
	}

	public Agency(String name, String address, String country, String email, String phone, String fax,
			Set<Banker> bankers, Set<Location> locations) {
		this.name = name;
		this.address = address;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.fax = fax;
		this.bankers = bankers;
		this.locations = locations;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_Agency", unique = true, nullable = false)
	public Integer getIdAgency() {
		return this.idAgency;
	}

	public void setIdAgency(Integer idAgency) {
		this.idAgency = idAgency;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Address", nullable = false, length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Country", nullable = false, length = 50)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "Email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Phone", nullable = false, length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Fax", nullable = false, length = 50)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agency")
	public Set<Banker> getBankers() {
		return this.bankers;
	}

	public void setBankers(Set<Banker> bankers) {
		this.bankers = bankers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agency")
	public Set<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

}
