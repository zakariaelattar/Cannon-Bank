package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RepositoryRestResource
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    Set<Transaction> findByAccountSrc_Client_UsernameOrAccountRcv_Client_Username( String username1 ,String  username2);

    /***
     *  Return the total received amount of a client
     *
     */

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.accountRcv.client.username = ?1")
    float sumReceivedTransactionClient(String username);

    /***
     *  Return the total sended  amount of a client
     *
     */
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.accountSrc.client.username = ?1")
    float sumSendedClient(String username);

    /***
     *  Return the total received and sended  amount of a client
     *
     */
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.accountSrc.client.username = ?1 or t.accountRcv.client.username = ?1")
    float sumTotalClient(String username1);

    /***
     *  Return the total received and sended tranfers and also recharge amount of a client
     *
     */





}
