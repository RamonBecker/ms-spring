package com.devsuperior.hroauth.entities;

import java.io.Serializable;
import java.util.Objects;



public class Role implements Serializable{

	private static final long serialVersionUID = 1L;	
	private String id;
	private String roleName;
	
	
	public Role() {
	}

	public Role(String id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
