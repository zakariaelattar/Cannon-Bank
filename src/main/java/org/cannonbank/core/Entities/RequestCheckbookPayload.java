package org.cannonbank.core.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class RequestCheckbookPayload  {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_request_checkbook", unique = true, nullable = false)
    private Integer idRequestCheckbook;
    private int paper_number;
    private int quantity;
}
