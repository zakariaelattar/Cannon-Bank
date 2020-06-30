package org.cannonbank.core.Entities;

import java.util.Date;
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

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credit_card")
public class CreditCard implements java.io.Serializable {


	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer cardId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	@ManyToOne
	private CategoryCc categoryCc;
	private String cardNumber;
	private String cvv;
	private String cardHolderFirstname;
	private String cardHolderLastname;

	@Temporal(TemporalType.DATE)
	private Date expiresDate;

	private double balance;


	public CreditCard(Account account, CategoryCc categoryCc,
					  String cardNumber, String cvv,
			Date expiresDate, double balance) {
		this.account = account;
		this.categoryCc = categoryCc;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiresDate = expiresDate;
		this.balance = balance;
	}

	public CreditCard(Account account, String cardHolderFirstName,
					  String cardHolderLastName, CategoryCc categoryCc,
					  String cardNumber, String cvv,
					  Date expiresDate) {
		this.account = account;
		this.cardHolderFirstname = cardHolderFirstName;
		this.cardHolderLastname = cardHolderLastName;
		this.categoryCc = categoryCc;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiresDate = expiresDate;
		this.balance = 0;
	}


}
