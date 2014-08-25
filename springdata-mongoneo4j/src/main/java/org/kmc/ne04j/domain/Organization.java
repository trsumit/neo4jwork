package org.kmc.ne04j.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/** Simple user class. */
@NodeEntity
public class Organization {

	@GraphId
	Long id;

	@Indexed
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	
	public void addEmployee(Employee employee) {
		this.employee.add(employee);
	}
	
	
	
	
	@RelatedTo(type = "work", direction = Direction.BOTH)
	Set<Employee> employee;
	public Organization() {
	}

	public Organization(String name) {
		this.name = name;
		this.employee = new HashSet<Employee>();
	}

}
