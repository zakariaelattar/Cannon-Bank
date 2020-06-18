package org.cannonbank.core.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RequestCardPayload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
