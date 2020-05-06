package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Account;
import org.cannonbank.core.Entities.Category_CC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Category_CCRepository extends JpaRepository<Long , Category_CC> {
}
