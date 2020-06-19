package org.cannonbank.core.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category_request")
public class CategoryRequest implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer categoryRequestId;

    private String name;
    private String description;





}
