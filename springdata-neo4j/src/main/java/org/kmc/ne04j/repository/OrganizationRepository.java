package org.kmc.ne04j.repository;

import java.util.List;

import org.kmc.ne04j.domain.Organization;
import org.springframework.data.neo4j.repository.GraphRepository;

/** Neo4j repository. */
public interface OrganizationRepository extends GraphRepository<Organization> {
	
	List<Organization> findByName(String name);
	
	
	
}
