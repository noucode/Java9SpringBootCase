package com.nouko.form;


public class CatalogForm 
{
    private String idCategory;
    private Integer categId;
    private String categname;
	private String sourceview ;
    
    
    public CatalogForm() {
    }
    
	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
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
	
	public String getSourceview() {
		return sourceview;
	}

	public void setSourceview(String sourceview) {
		this.sourceview = sourceview;
	}


	public void reset()     
	{
		idCategory = "";
		categId = null ;
		categname = "" ;
	}    
	
}
