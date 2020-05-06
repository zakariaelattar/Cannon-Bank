package org.cannonbank.core.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Checkbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id_cb;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category_CB type;

    private int is_finished;

}
