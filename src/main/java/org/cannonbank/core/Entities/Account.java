package org.cannonbank.core.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity
@Table(name = "account", catalog = "can_bank")
public class Account implements java.io.Serializable {

	private int idAccount;
	private CategoryAccount categoryAccount;
	private Client client;
	private int accountNumber;
	private String bic;
	private String iban;
	private float balance;
	private Date creationDate;
	private boolean isSuspended;
	private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);
	private Set<Checkbook> checkbooks = new HashSet<Checkbook>(0);
	private Set<Transaction> transactionsForIdS = new HashSet<Transaction>(0);
	private Set<Transaction> transactionsForIdR = new HashSet<Transaction>(0);

	public Account() {
	}

	public Account(int idAccount, CategoryAccount categoryAccount, Client client, int accountNumber, String bic,
			String iban, float balance, Date creationDate, boolean isSuspended) {
		this.idAccount = idAccount;
		this.categoryAccount = categoryAccount;
		this.client = client;
		this.accountNumber = accountNumber;
		this.bic = bic;
		this.iban = iban;
		this.balance = balance;
		this.creationDate = creationDate;
		this.isSuspended = isSuspended;
	}

	public Account(int idAccount, CategoryAccount categoryAccount, Client client, int accountNumber, String bic,
			String iban, float balance, Date creationDate, boolean isSuspended, Set<CreditCard> creditCards,
			Set<Checkbook> checkbooks, Set<Transaction> transactionsForIdS, Set<Transaction> transactionsForIdR) {
		this.idAccount = idAccount;
		this.categoryAccount = categoryAccount;
		this.client = client;
		this.accountNumber = accountNumber;
		this.bic = bic;
		this.iban = iban;
		this.balance = balance;
		this.creationDate = creationDate;
		this.isSuspended = isSuspended;
		this.creditCards = creditCards;
		this.checkbooks = checkbooks;
		this.transactionsForIdS = transactionsForIdS;
		this.transactionsForIdR = transactionsForIdR;
	}

	@Id

	@Column(name = "id_Account", unique = true, nullable = false)
	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Type", nullable = false)
	public CategoryAccount getCategoryAccount() {
		return this.categoryAccount;
	}

	public void setCategoryAccount(CategoryAccount categoryAccount) {
		this.categoryAccount = categoryAccount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Client", nullable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "account_number", nullable = false)
	public int getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name = "BIC", nullable = false, length = 50)
	public String getBic() {
		return this.bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	@Column(name = "IBAN", nullable = false, length = 50)
	public String getIban() {
		return this.iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Column(name = "Balance", nullable = false, precision = 12, scale = 0)
	public float getBalance() {
		return this.balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Creation_Date", nullable = false, length = 10)
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "is_Suspended", nullable = false)
	public boolean isIsSuspended() {
		return this.isSuspended;
	}

	public void setIsSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<CreditCard> getCreditCards() {
		return this.creditCards;
	}

	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public Set<Checkbook> getCheckbooks() {
		return this.checkbooks;
	}

	public void setCheckbooks(Set<Checkbook> checkbooks) {
		this.checkbooks = checkbooks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountByIdS")
	public Set<Transaction> getTransactionsForIdS() {
		return this.transactionsForIdS;
	}

	public void setTransactionsForIdS(Set<Transaction> transactionsForIdS) {
		this.transactionsForIdS = transactionsForIdS;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountByIdR")
	public Set<Transaction> getTransactionsForIdR() {
		return this.transactionsForIdR;
	}

	public void setTransactionsForIdR(Set<Transaction> transactionsForIdR) {
		this.transactionsForIdR = transactionsForIdR;
	}

}
