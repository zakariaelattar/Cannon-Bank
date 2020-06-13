package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.CategoryCc;
import org.cannonbank.core.Entities.CategoryRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Category_RequestRepository extends JpaRepository<CategoryRequest,Integer> {

    CategoryRequest findByName(String requestType);
}
