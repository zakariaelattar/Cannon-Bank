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

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category_cc")
public class CategoryCc implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer categoryCcId;

	private String name;
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryCc")
	private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);


}
