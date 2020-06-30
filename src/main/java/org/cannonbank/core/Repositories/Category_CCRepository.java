package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.CategoryCc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Category_CCRepository extends JpaRepository<CategoryCc,Integer> {
    CategoryCc findByName(String categoryCcName);
}
