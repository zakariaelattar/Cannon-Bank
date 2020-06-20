package org.cannonbank.core.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int rechargeId;

    @ManyToOne
    private Account account;
    private String receiverPhoneNumber;
    private float amount;


    @Temporal(TemporalType.DATE)
    private Date date;

    public Recharge(Account account, String receiverPhoneNumber, float amount) {
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.account = account;
        this.amount = amount;
        this.date = new Date();
    }
}
