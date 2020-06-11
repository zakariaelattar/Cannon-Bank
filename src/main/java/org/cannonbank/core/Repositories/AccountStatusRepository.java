package org.cannonbank.core.Repositories;

import org.cannonbank.core.Entities.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, Integer> {

    AccountStatus findByCode(int code);
}
