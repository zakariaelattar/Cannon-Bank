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
@Table(name = "transaction", catalog = "can_bank")
public class Transaction implements java.io.Serializable {

	private Integer idTransaction;
	private Account accountByIdS;
	private Account accountByIdR;
	private Transaction transaction;
	private double amount;
	private double oldBalanceS;
	private double oldBalanceR;
	private Date date;
	private Set<Transaction> transactions = new HashSet<Transaction>(0);

	public Transaction() {
	}

	public Transaction(Account accountByIdS, Account accountByIdR, Transaction transaction, double amount,
			double oldBalanceS, double oldBalanceR, Date date) {
		this.accountByIdS = accountByIdS;
		this.accountByIdR = accountByIdR;
		this.transaction = transaction;
		this.amount = amount;
		this.oldBalanceS = oldBalanceS;
		this.oldBalanceR = oldBalanceR;
		this.date = date;
	}

	public Transaction(Account accountByIdS, Account accountByIdR, Transaction transaction, double amount,
			double oldBalanceS, double oldBalanceR, Date date, Set<Transaction> transactions) {
		this.accountByIdS = accountByIdS;
		this.accountByIdR = accountByIdR;
		this.transaction = transaction;
		this.amount = amount;
		this.oldBalanceS = oldBalanceS;
		this.oldBalanceR = oldBalanceR;
		this.date = date;
		this.transactions = transactions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_Transaction", unique = true, nullable = false)
	public Integer getIdTransaction() {
		return this.idTransaction;
	}

	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_S", nullable = false)
	public Account getAccountByIdS() {
		return this.accountByIdS;
	}

	public void setAccountByIdS(Account accountByIdS) {
		this.accountByIdS = accountByIdS;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_R", nullable = false)
	public Account getAccountByIdR() {
		return this.accountByIdR;
	}

	public void setAccountByIdR(Account accountByIdR) {
		this.accountByIdR = accountByIdR;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Type", nullable = false)
	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Column(name = "Amount", nullable = false, precision = 22, scale = 0)
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name = "oldBalance_S", nullable = false, precision = 22, scale = 0)
	public double getOldBalanceS() {
		return this.oldBalanceS;
	}

	public void setOldBalanceS(double oldBalanceS) {
		this.oldBalanceS = oldBalanceS;
	}

	@Column(name = "oldBalance_R", nullable = false, precision = 22, scale = 0)
	public double getOldBalanceR() {
		return this.oldBalanceR;
	}

	public void setOldBalanceR(double oldBalanceR) {
		this.oldBalanceR = oldBalanceR;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction")
	public Set<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

}
