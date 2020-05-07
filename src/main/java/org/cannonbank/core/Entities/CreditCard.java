package org.cannonbank.core.Entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor

@Entity
@Table(name = "credit_card", catalog = "can_bank")
public class CreditCard implements java.io.Serializable {

	private Integer idCard;
	private Account account;
	private CategoryCc categoryCc;
	private int cardNumber;
	private String cardHolder;
	private int cvv;
	private Date expiresDate;
	private double balance;

	public CreditCard() {
	}

	public CreditCard(Account account, CategoryCc categoryCc, int cardNumber, String cardHolder, int cvv,
			Date expiresDate, double balance) {
		this.account = account;
		this.categoryCc = categoryCc;
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.cvv = cvv;
		this.expiresDate = expiresDate;
		this.balance = balance;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_Card", unique = true, nullable = false)
	public Integer getIdCard() {
		return this.idCard;
	}

	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Account", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Type", nullable = false)
	public CategoryCc getCategoryCc() {
		return this.categoryCc;
	}

	public void setCategoryCc(CategoryCc categoryCc) {
		this.categoryCc = categoryCc;
	}

	@Column(name = "Card_Number", nullable = false)
	public int getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "Card_Holder", nullable = false, length = 50)
	public String getCardHolder() {
		return this.cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	@Column(name = "cvv", nullable = false)
	public int getCvv() {
		return this.cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Expires_Date", nullable = false, length = 10)
	public Date getExpiresDate() {
		return this.expiresDate;
	}

	public void setExpiresDate(Date expiresDate) {
		this.expiresDate = expiresDate;
	}

	@Column(name = "Balance", nullable = false, precision = 22, scale = 0)
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
