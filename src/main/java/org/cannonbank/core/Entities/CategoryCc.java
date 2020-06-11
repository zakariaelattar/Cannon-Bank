package org.cannonbank.core.Entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor

@Entity

public class CategoryCc implements java.io.Serializable {

	private Integer idCard;
	private String name;
	private String description;
	private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);
	private Set<Request> requests = new HashSet<Request>(0);

	public CategoryCc() {
	}

	public CategoryCc(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public CategoryCc(String name, String description, Set<CreditCard> creditCards, Set<Request> requests) {
		this.name = name;
		this.description = description;
		this.creditCards = creditCards;
		this.requests = requests;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_Card", unique = true, nullable = false)
	public Integer getIdCard() {
		return this.idCard;
	}

	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}

	@Column(name = "Name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Description", nullable = false, length = 50)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryCc")
	public Set<CreditCard> getCreditCards() {
		return this.creditCards;
	}

	public void setCreditCards(Set<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryCc")
	public Set<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

}
