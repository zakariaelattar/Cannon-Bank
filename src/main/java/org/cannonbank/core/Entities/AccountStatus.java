package org.cannonbank.core.Entities;


import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account_status")
public class AccountStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int StatusId;
    private String name;
    private int code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="status")
    private Set<Account> accounts;
}
