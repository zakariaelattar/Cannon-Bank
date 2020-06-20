package org.cannonbank.core.Entities;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Request implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer idRequest;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryRequest categoryRequest;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;


	@Temporal(TemporalType.DATE)
	private Date date;

	private boolean isOpen;

	@OneToOne
	private RequestCheckbookPayload requestCheckbookPayload;
}
