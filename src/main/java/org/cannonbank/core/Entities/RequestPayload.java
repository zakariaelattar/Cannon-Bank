package org.cannonbank.core.Entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class RequestPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "requestPayload")
    private Request request;


}
