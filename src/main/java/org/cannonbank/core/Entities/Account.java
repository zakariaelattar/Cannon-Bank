package org.cannonbank.core.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")

public class Account implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;

	@ManyToOne
	private CategoryAccount categoryAccount;

	@ManyToOne
	private Client client;

	private String accountNumber;
	private String bic;
	private String iban;
	private float balance;

	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@ManyToOne
	private AccountStatus status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="account")
	private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Checkbook> checkbooks = new HashSet<Checkbook>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountSrc")
	private Set<Transaction> transactionsForIdS = new HashSet<Transaction>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountRcv")
	private Set<Transaction> transactionsForIdR = new HashSet<Transaction>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Recharge> recharges = new HashSet<Recharge>(0);

}
