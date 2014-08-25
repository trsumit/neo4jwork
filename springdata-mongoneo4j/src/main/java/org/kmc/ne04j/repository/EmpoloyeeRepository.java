package org.kmc.ne04j.repository;

import org.kmc.ne04j.domain.Employee;
import org.kmc.ne04j.domain.User;
import org.springframework.data.neo4j.repository.GraphRepository;

/** Neo4j repository. */
public interface EmpoloyeeRepository extends GraphRepository<Employee> {
	
	User findByLogin(String login);
	

	
}
