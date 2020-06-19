package org.cannonbank.core.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cannonbank.core.Security.models.User;


@Data

@NoArgsConstructor
@Entity

@Table(name = "banker")
public class Banker extends User implements java.io.Serializable  {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agency_id", nullable = false)
	private Agency agency;


	private String fname;
	private String lname;
	private String address;
	private String phone;

	public Banker(String username,
				  String email,
				  String password,
				  Agency agency,
				  String fname,
				  String lname,
				  String address,
				  String phone,
				  Date birthDate,
				  Date joiningDate) {

		super(username, email, password);

		this.agency = agency;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phone = phone;
		this.birthDate = birthDate;
		this.joiningDate = joiningDate;


	}

	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "banker")
	private Set<Client> clients = new HashSet<Client>(0);



}
