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


@Data
@AllArgsConstructor

@Entity

public class Banker implements java.io.Serializable {

	private Integer idBanker;
	private Agency agency;
	private String fname;
	private String lname;
	private String email;
	private String address;
	private String phone;
	private Date birthDate;
	private Date joiningDate;
	private Set<Client> clients = new HashSet<Client>(0);

	public Banker() {
	}

	public Banker(Agency agency, String fname, String lname, String email, String address, String phone, Date birthDate,
			Date joiningDate) {
		this.agency = agency;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.birthDate = birthDate;
		this.joiningDate = joiningDate;
	}

	public Banker(Agency agency, String fname, String lname, String email, String address, String phone, Date birthDate,
			Date joiningDate, Set<Client> clients) {
		this.agency = agency;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.birthDate = birthDate;
		this.joiningDate = joiningDate;
		this.clients = clients;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_Banker", unique = true, nullable = false)
	public Integer getIdBanker() {
		return this.idBanker;
	}

	public void setIdBanker(Integer idBanker) {
		this.idBanker = idBanker;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Agency", nullable = false)
	public Agency getAgency() {
		return this.agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	@Column(name = "fName", nullable = false, length = 50)
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name = "lName", nullable = false, length = 50)
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Column(name = "Email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Address", nullable = false, length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Phone", nullable = false, length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Birth_Date", nullable = false, length = 10)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Joining_Date", nullable = false, length = 10)
	public Date getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "banker")
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
