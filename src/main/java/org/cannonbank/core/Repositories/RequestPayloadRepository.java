package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.RequestPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RequestPayloadRepository extends JpaRepository<RequestPayload,Integer> {
}
