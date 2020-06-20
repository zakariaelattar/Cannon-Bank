package org.cannonbank.core.Entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import lombok.*;


@Getter
@Setter
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy="categoryAccount")
	private Set<Account> accounts;




}
