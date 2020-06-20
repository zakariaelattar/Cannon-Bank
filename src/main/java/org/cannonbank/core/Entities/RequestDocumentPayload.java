package org.cannonbank.core.Entities;

import lombok.*;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RequestDocumentPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
