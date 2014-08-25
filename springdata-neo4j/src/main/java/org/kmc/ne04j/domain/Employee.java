package org.kmc.ne04j.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/** Simple user class. */
@NodeEntity 
public class Employee {

	@GraphId Long id;
	
	@Indexed private String login;
	
	private String fullName;

    @RelatedTo(type = "knows", direction = Direction.BOTH)
    Set<Organization> organizatoin;	
	
	public Employee() {}
	
	public Employee(String login, String fullName) {
		this.login = login;
		this.fullName = fullName;
		
		this.organizatoin = new HashSet<Organization>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Set<Organization> getOrganizatoin() {
		return organizatoin;
	}

	public void setOrganizatoin(Set<Organization> organizatoin) {
		this.organizatoin = organizatoin;
	}	
	
	
}