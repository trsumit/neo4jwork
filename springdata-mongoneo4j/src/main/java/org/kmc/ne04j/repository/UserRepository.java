package org.kmc.ne04j.repository;

import java.util.List;

import org.kmc.ne04j.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

/** Neo4j repository. */
public interface UserRepository extends GraphRepository<User> {
	
	User findByLogin(String login);
	
	@Query("START root=node:User(login = 'root') MATCH root-[:knows]->friends RETURN friends")
	List<User> findFriendsOfRoot();
	
}
