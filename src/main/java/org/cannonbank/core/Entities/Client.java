package org.cannonbank.core.Entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cannonbank.core.Security.models.User;
import org.springframework.lang.Nullable;


@Data

@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client extends User implements java.io.Serializable {

	@ManyToOne
	private Banker banker;

	private String fname;
	private String lname;
	private String address;
	private String cni;
	private String phone;

	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Temporal(TemporalType.DATE)
	private Date joiningDate;


	private boolean isSuspended;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Support> supports = new HashSet<Support>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Account> accounts = new HashSet<Account>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	private Set<Request> requests = new HashSet<Request>(0);

	public Client(String username,
				  String email,
				  String password,
				  String fname,
				  String lname,
				  String address,
				  String cni,
				  String phone,
				  Banker banker,
				  Date birthDate,
				  Date joiningDate) {

		super(username, email, password);
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phone = phone;
		this.banker = banker;
		this.cni = cni;
		this.birthDate = birthDate;
		this.joiningDate = joiningDate;
		this.isSuspended = false;
	}


}
