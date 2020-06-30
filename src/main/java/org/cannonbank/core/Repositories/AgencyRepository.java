package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AgencyRepository extends JpaRepository<Agency,Integer> {


    Agency findByName(String name);
}
