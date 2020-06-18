package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.Request;
import org.cannonbank.core.Entities.RequestCheckbookPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RequestCheckbookPayloadRepository extends JpaRepository<RequestCheckbookPayload,Integer> {
}
