package org.cannonbank.core.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category_Account extends Category {

    @OneToMany(
            mappedBy = "category_accounts",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Account> accountList = new ArrayList<>();


}
