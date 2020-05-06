package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Credit_Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Credit_CardRepository extends JpaRepository<Long , Credit_Card> {
}
