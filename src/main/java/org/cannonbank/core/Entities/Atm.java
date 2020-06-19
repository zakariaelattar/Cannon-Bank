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

@Table(name = "atm")
public class Atm implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer atmId;

	private String address;
	private float longitude;
	private float latitude;



}
