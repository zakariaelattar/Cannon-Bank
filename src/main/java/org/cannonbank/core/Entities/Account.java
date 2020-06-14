package org.cannonbank.core.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Account", unique = true, nullable = false)
	private int idAccount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Type", nullable = false)
	private CategoryAccount categoryAccount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Client", nullable = false)
	private Client client;

	@Column(name = "account_number", nullable = false)
	private String accountNumber;

	@Column(name = "BIC", nullable = false, length = 50)
	private String bic;

	@Column(name = "IBAN", nullable = false, length = 50)
	private String iban;

	@Column(name = "Balance", nullable = false, precision = 12, scale = 0)
	private float balance;

	@Temporal(TemporalType.DATE)
	@Column(name = "Creation_Date", nullable = false, length = 10)
	private Date creationDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status", nullable = false)
	private AccountStatus status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Checkbook> checkbooks = new HashSet<Checkbook>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountByIdS")
	private Set<Transaction> transactionsForIdS = new HashSet<Transaction>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountByIdR")
	private Set<Transaction> transactionsForIdR = new HashSet<Transaction>(0);







}
