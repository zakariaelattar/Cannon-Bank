package org.cannonbank.core.Entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="category_account")
public class CategoryAccount implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer categoryAccountId;


	private String name;


	private String description;

	@OneToMany(mappedBy = "categoryAccount")
	private Set<Account> accounts;




}
