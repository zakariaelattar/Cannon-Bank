package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LocationRepository extends JpaRepository<Location,Integer> {
}
