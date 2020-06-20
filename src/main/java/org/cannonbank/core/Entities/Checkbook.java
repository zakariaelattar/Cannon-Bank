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

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "checkbook")
public class Checkbook implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer cbId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Account", nullable = false)
	private Account account;

	@ManyToOne

	private CategoryCb categoryCb;

	private boolean isFinished;


}
