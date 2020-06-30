package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.CategoryCb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Category_CBRepository extends JpaRepository<CategoryCb,Integer> {
}
