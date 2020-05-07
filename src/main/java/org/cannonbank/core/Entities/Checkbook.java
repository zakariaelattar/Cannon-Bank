package org.cannonbank.core.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor

@Entity
@Table(name = "checkbook", catalog = "can_bank")
public class Checkbook implements java.io.Serializable {

	private Integer idCb;
	private Account account;
	private CategoryCb categoryCb;
	private boolean isFinished;

	public Checkbook() {
	}

	public Checkbook(Account account, CategoryCb categoryCb, boolean isFinished) {
		this.account = account;
		this.categoryCb = categoryCb;
		this.isFinished = isFinished;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Account", nullable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Type", nullable = false)
	public CategoryCb getCategoryCb() {
		return this.categoryCb;
	}

	public void setCategoryCb(CategoryCb categoryCb) {
		this.categoryCb = categoryCb;
	}

	@Column(name = "is_Finished", nullable = false)
	public boolean isIsFinished() {
		return this.isFinished;
	}

	public void setIsFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

}
