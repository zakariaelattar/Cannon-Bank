package org.cannonbank.core.Entities;

import java.util.Date;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Transaction implements java.io.Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id_Transaction", unique = true, nullable = false)
	private int idTransaction;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_S", nullable = false)
	private Account accountByIdS;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_R", nullable = false)
	private Account accountByIdR;

	@Column(name = "Amount", nullable = false, precision = 22, scale = 0)
	private double amount;

	@Column(name = "oldBalance_S", nullable = false, precision = 22, scale = 0)
	private double oldBalanceS;

	@Column(name = "oldBalance_R", nullable = false, precision = 22, scale = 0)
	private double oldBalanceR;



	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false, length = 10)
	private Date date;



}
