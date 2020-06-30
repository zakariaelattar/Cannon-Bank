package org.cannonbank.core.Entities;

import java.util.HashSet;
import java.util.Set;
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


@Table(name="category_cb")
public class CategoryCb implements java.io.Serializable {


	@Id
	@GeneratedValue(strategy = IDENTITY)

	private Integer categoryCbId;
	private String name;
	private String description;

	@OneToMany(mappedBy = "categoryCb")
	private Set<Checkbook> checkbooks = new HashSet<Checkbook>(0);



	public CategoryCb(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public CategoryCb(String name, String description, Set<Checkbook> checkbooks) {
		this.name = name;
		this.description = description;
		this.checkbooks = checkbooks;
	}



	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category_cb")
	public Set<Checkbook> getCheckbooks() {
		return this.checkbooks;
	}

	public void setCheckbooks(Set<Checkbook> checkbooks) {
		this.checkbooks = checkbooks;
	}

}
