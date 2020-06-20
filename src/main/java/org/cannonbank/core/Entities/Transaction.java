package org.cannonbank.core.Entities;

import java.util.Date;

import javax.persistence.*;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "transaction_id", unique = true, nullable = false)
	private int idTransaction;


	@ManyToOne
	private Account accountSrc;

	@ManyToOne
	private Account accountRcv;

	private double amount;
	private double oldBalanceSrc;
	private double oldBalanceRcv;


	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false, length = 10)
	private Date date;



}
