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

public class CategoryCb implements java.io.Serializable {

	private Integer idCb;
	private String name;
	private String description;
	private Set<Checkbook> checkbooks = new HashSet<Checkbook>(0);

	public CategoryCb() {
	}

	public CategoryCb(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public CategoryCb(String name, String description, Set<Checkbook> checkbooks) {
		this.name = name;
		this.description = description;
		this.checkbooks = checkbooks;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_CB", unique = true, nullable = false)
	public Integer getIdCb() {
		return this.idCb;
	}

	public void setIdCb(Integer idCb) {
		this.idCb = idCb;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryCb")
	public Set<Checkbook> getCheckbooks() {
		return this.checkbooks;
	}

	public void setCheckbooks(Set<Checkbook> checkbooks) {
		this.checkbooks = checkbooks;
	}

}
