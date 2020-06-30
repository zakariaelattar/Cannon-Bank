package org.cannonbank.core.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter

@NoArgsConstructor
@Entity
public class RequestCardPayload  extends RequestPayload{


    private String categoryCc;
    private String accountNumber;

    public RequestCardPayload(String categoryCc, String accountNumber) {

        super();
        this.categoryCc = categoryCc;
        this.accountNumber = accountNumber;

    }

}
