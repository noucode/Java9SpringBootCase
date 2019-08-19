package com.bell.nouko.domain;

import java.io.Serializable;

public class Category implements Serializable
{
	private static final long serialVersionUID = 1L;	

    private Integer categId;
    private String categname;
    private String description;
    
    public Category() {
    }
    
	public Integer getCategId() {
		return categId;
	}
	public void setCategId(Integer categId) {
		this.categId = categId;
	}
	public String getCategname() {
		return categname;
	}
	public void setCategname(String categname) {
		this.categname = categname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categId == null) ? 0 : categId.hashCode());
		result = prime * result
				+ ((categname == null) ? 0 : categname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categId == null) {
			if (other.categId != null)
				return false;
		} else if (!categId.equals(other.categId))
			return false;
		if (categname == null) {
			if (other.categname != null)
				return false;
		} else if (!categname.equals(other.categname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [categId=" + categId + ", categname=" + categname
				+ ", description=" + description + "]";
	}
	
	
}
