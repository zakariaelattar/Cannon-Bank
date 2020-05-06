package org.cannonbank.core.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category_CC extends Category{

    @OneToMany(
            mappedBy = "category_ccs",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Credit_Card> credit_cardList = new ArrayList<>();



}
