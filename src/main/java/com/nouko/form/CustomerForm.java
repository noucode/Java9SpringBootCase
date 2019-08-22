/** LoginForm.java
 * 
 * @author <a href="mailto:nouko2@hotmail.com>Jean-Claude Nouko</a>
 * @created March 25, 2007
 * @version 1.0
 */
package com.nouko.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CustomerForm  
{
	private Long customerId;
    
	@NotNull(message = "firstname must not be null")
    private String firstname;	
    
    @NotNull
    private String lastname;
    
    @NotNull
    private String phone;
       
    @NotNull
    @Size(min=1, max=50, message="{error.email.required}")
    private String email;
    
	@NotNull
	@Size(min=1, max=50, message="{error.email.required}")
    private String confemail;
    
     @Size(min=1, max=30, message="{error.email.required}")
    private String password;
    
    @Size(min=1, max=30, message="{error.email.required}")
    private String confpassword;
    
	private String sourceview ;
    private String remember = "";
	private String marketingOk = "";
    private String acceptTerms = "";
    private String step = null;

    
    public CustomerForm() {
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getConfemail() {
		return confemail;
	}

	public void setConfemail(String confemail) {
		this.confemail = confemail;
	}

	public String getConfpassword() {
		return confpassword;
	}

	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}
		
    public String getMarketingOk() {
		return marketingOk;
	}

	public void setMarketingOk(String marketingOk) {
		this.marketingOk = marketingOk;
	}

	public String getAcceptTerms() {
		return acceptTerms;
	}

	public void setAcceptTerms(String acceptTerms) {
		this.acceptTerms = acceptTerms;
	}

	
	public String getSourceview() {
		return sourceview;
	}

	public void setSourceview(String sourceview) {
		this.sourceview = sourceview;
	}


	public String getStep() 
	{ return (this.step);  }
	
	public void setStep(String step) 
	{ this.step = step;  }
	
	
	public void reset()
	{
		this.password = "";
		this.firstname = "";
		this.lastname = "";
		this.phone = "";
		this.email = "";
		this.confemail = "";
		this.confpassword = "";
	}
	
}

