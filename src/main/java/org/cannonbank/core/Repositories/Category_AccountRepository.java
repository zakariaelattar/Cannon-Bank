package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.CategoryAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Category_AccountRepository extends JpaRepository<CategoryAccount,Integer> {


            CategoryAccount findByName(String name);

    @Query("SELECT name FROM CategoryAccount t WHERE t.categoryAccountId = (SELECT categoryAccount FROM Account a WHERE a.accountNumber = ?1)")
    String findCategoryAccountByAccountNumber(String accountNumber);
}
