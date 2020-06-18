package org.cannonbank.core.Entities;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Request implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)

	private Integer idRequest;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Category", nullable = false)
	private CategoryRequest categoryRequest;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Client", nullable = false)
	private Client client;


	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false, length = 10)
	private Date date;


	@Column(name = "is_Open", nullable = false)
	private boolean isOpen;

	@OneToOne
	private RequestCheckbookPayload requestCheckbookPayload;
}
