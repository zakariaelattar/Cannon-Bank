package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Atm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AtmRepository extends JpaRepository<Long , Atm> {
}
