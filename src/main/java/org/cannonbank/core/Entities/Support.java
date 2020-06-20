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
	private String name;
	private String email;
	private String country;
	private String title;
	private String message;
	private boolean isOpen;

	@Temporal(TemporalType.DATE)
	private Date date;



	public Support(Client client, String name, String email, String country, String title, String message,
			boolean isOpen, Date date) {


		this.client = client;
		this.name = name;
		this.email = email;
		this.country = country;
		this.title = title;
		this.message = message;
		this.isOpen = isOpen;
		this.date = date;
	}


}
