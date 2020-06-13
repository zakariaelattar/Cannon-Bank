package org.cannonbank.core.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Checkbook implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_CB", unique = true, nullable = false)
	private Integer idCb;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Account", nullable = false)
	private Account account;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Type", nullable = false)
	private CategoryCb categoryCb;

	@Column(name = "is_Finished", nullable = false)
	private boolean isFinished;


}
