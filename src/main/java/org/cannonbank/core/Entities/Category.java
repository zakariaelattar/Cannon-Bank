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

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id_type;
    private String name;
    private String description;



}
