package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account,Integer> {

	@Query(value = "SELECT u FROM Account u WHERE u.idAccount = :id")
	Account findById(@Param("id") int id);


	

}
