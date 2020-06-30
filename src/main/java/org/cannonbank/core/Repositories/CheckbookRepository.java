package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Checkbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CheckbookRepository extends JpaRepository<Checkbook,Integer> {
}
