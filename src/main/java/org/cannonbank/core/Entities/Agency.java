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
@NoArgsConstructor

@Entity

@Table(name = "agency")
public class Agency implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer agencyId;


	private String name;
	private String address;
	private String country;
	private String email;
	private String phone;
	private String fax;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agency")
	private Set<Banker> bankers = new HashSet<Banker>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agency")
	private Set<Location> locations = new HashSet<Location>(0);


	public Agency(String name, String address, String country, String email, String phone, String fax) {
		this.name = name;
		this.address = address;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.fax = fax;
	}





}
