package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface
AccountRepository extends JpaRepository<Account ,Integer> {

    Account findByAccountId(int id);
    Account findByAccountNumber(String accountNumber);


}
