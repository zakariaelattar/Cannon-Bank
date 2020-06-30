package org.cannonbank.core.Repositories;


import org.cannonbank.core.Entities.RequestCardPayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RequestCardPayloadRepository extends JpaRepository<RequestCardPayload,Integer> {
    RequestCardPayload findById(int id);
}
