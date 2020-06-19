package org.cannonbank.core.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "category_transaction")
public class CategoryTransaction implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer transactionId;
	private String name;
	private String description;

	public CategoryTransaction(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
