package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.Set;

@RepositoryRestResource
public interface RechargeRepository extends JpaRepository<Recharge,Integer> {


    Set<Recharge> findByAccount_Client_Username(String username);

    /***
     *  Return the total amount  sendded as recharge of a client
     *
     */
    @Query("SELECT SUM(r.amount) FROM Recharge r WHERE r.account.client.username = ?1")
    float sumRechargeClient(String username);

}
