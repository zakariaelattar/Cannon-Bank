package org.cannonbank.core.Entities;

import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter

@NoArgsConstructor
@Entity
public class RequestCardPayload  extends RequestPayload{


}
