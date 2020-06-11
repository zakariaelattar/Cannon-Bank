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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor

@Entity
@Table(name = "client", catalog = "bank")
public class Client implements java.io.Serializable {

	private Integer idClient;
	private Banker banker;
	private String fname;
	private String lname;
	private String email;
	private String address;
	private String phone;
	private Date birthDate;
	private Date joiningDate;
	private boolean isSuspended;
	private Login login;
	private Set<Support> supports = new HashSet<Support>(0);
	private Set<Account> accounts = new HashSet<Account>(0);
	private Set<Request> requests = new HashSet<Request>(0);

	public Client() {
	}

	public Client(Banker banker, String fname, String lname, String email, String address, String phone, Date birthDate,
			Date joiningDate, boolean isSuspended) {
		this.banker = banker;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.birthDate = birthDate;
		this.joiningDate = joiningDate;
		this.isSuspended = isSuspended;
	}

	public Client(Banker banker, String fname, String lname, String email, String address, String phone, Date birthDate,
			Date joiningDate, boolean isSuspended, Login login, Set<Support> supports, Set<Account> accounts,
			Set<Request> requests) {
		this.banker = banker;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.birthDate = birthDate;
		this.joiningDate = joiningDate;
		this.isSuspended = isSuspended;
		this.login = login;
		this.supports = supports;
		this.accounts = accounts;
		this.requests = requests;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_client", unique = true, nullable = false)
	public Integer getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Banker", nullable = false)
	public Banker getBanker() {
		return this.banker;
	}

	public void setBanker(Banker banker) {
		this.banker = banker;
	}

	@Column(name = "fName", nullable = false, length = 10)
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

	@Column(name = "is_Suspended", nullable = false)
	public boolean isIsSuspended() {
		return this.isSuspended;
	}

	public void setIsSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "client")
	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Support> getSupports() {
		return this.supports;
	}

	public void setSupports(Set<Support> supports) {
		this.supports = supports;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

}
