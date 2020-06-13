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
@NoArgsConstructor
@Entity

public class CategoryCc implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_Card", unique = true, nullable = false)
	private Integer idCard;

	@Column(name = "Name", nullable = false, length = 50)
	private String name;

	@Column(name = "Description", nullable = false, length = 50)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryCc")
	private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);


}
