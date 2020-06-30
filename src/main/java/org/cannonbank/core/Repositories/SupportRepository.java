package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SupportRepository extends JpaRepository<Support,Integer> {
}
