package org.cannonbank.core.Repositories;

import org.cannonbank.core.Entities.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, Integer> {

    AccountStatus findByCode(int code);

    @Query("SELECT name FROM AccountStatus t WHERE t.StatusId = (SELECT status FROM Account a WHERE a.accountNumber = ?1)")
    String findStatusByAccountNumber(String accountNumber);
}
