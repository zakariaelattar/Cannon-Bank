package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Credit_CardRepository extends JpaRepository<CreditCard,Integer> {
}
