package org.cannonbank.core.Entities;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter

@NoArgsConstructor
@Entity

public class RequestCheckbookPayload extends RequestPayload {

    private int paper_number;
    private int quantity;

    public RequestCheckbookPayload(int paper_number, int quantity) {

        super();
        this.paper_number = paper_number;
        this.quantity = quantity;
    }
}
