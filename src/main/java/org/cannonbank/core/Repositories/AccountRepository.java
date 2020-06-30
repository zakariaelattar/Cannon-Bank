package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface
AccountRepository extends JpaRepository<Account ,Integer> {

    Account findByAccountId(int id);
    Account findByAccountNumber(String accountNumber);

}
