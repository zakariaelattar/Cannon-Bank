package org.cannonbank.core.Security.repository;


import org.cannonbank.core.Security.models.ERole;
import org.cannonbank.core.Security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
