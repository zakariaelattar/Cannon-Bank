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
@NoArgsConstructor
@Entity
@Table(name = "client", catalog = "bank")
public class Client implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_client", unique = true, nullable = false)
	private Integer idClient;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Banker", nullable = false)
	private Banker banker;

	@Column(name = "fName", nullable = false, length = 10)
	private String fname;


	@Column(name = "lName", nullable = false, length = 50)
	private String lname;

	@Column(name = "Email", nullable = false, length = 50)
	private String email;

	@Column(name = "Address", nullable = false, length = 50)
	private String address;

	@Column(name = "Cni", nullable = false, length = 50)
	private String cni;

	@Column(name = "Phone", nullable = false, length = 50)
	private String phone;

	@Temporal(TemporalType.DATE)
	@Column(name = "Birth_Date", nullable = false, length = 10)
	private Date birthDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "Joining_Date", nullable = false, length = 10)
	private Date joiningDate;

	@Column(name = "is_Suspended", nullable = false)
	private boolean isSuspended;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Support> supports = new HashSet<Support>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Account> accounts = new HashSet<Account>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Request> requests = new HashSet<Request>(0);



}
