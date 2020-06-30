package org.cannonbank.core.Entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Support implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer idTicket;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Client", nullable = false)
	private Client client;
	private String subject;
	private String replyMethod;
	private String message;
	private boolean isOpen;

	@Temporal(TemporalType.DATE)
	private Date date;



	public Support(Client client, String subject, String message) {


		this.client = client;
		this.message = message;
		this.subject = subject;
		this.isOpen = isOpen;
		this.date = new Date();
		isOpen = true;
	}


}
