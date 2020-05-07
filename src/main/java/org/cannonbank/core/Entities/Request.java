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
@Table(name = "request", catalog = "can_bank")
public class Request implements java.io.Serializable {

	private Integer idRequest;
	private CategoryCc categoryCc;
	private Client client;
	private String type;
	private Date date;
	private boolean isOpen;

	public Request() {
	}

	public Request(CategoryCc categoryCc, Client client, String type, Date date, boolean isOpen) {
		this.categoryCc = categoryCc;
		this.client = client;
		this.type = type;
		this.date = date;
		this.isOpen = isOpen;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_Request", unique = true, nullable = false)
	public Integer getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(Integer idRequest) {
		this.idRequest = idRequest;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Type", nullable = false)
	public CategoryCc getCategoryCc() {
		return this.categoryCc;
	}

	public void setCategoryCc(CategoryCc categoryCc) {
		this.categoryCc = categoryCc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Client", nullable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "Type", nullable = false, length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "is_Open", nullable = false)
	public boolean isIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

}
