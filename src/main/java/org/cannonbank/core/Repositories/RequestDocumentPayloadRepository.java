package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.RequestDocumentPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RequestDocumentPayloadRepository extends JpaRepository<RequestDocumentPayload,Integer> {
}
