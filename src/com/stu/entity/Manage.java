package com.stu.entity;

public class Manage {
	private String manageId;
	private String managePassword;
	private String manageName;
    private String manageAuthority;
	public Manage() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	 
	public Manage(String manageid, String managePassword, String manageName) {
		super();
		this.manageId = manageid;
		this.managePassword = managePassword;
		this.manageName =manageName;
	}

	public Manage(String manage, String managePassword, String manageName, String manageAuthority) {
		super();
		this.manageId = manage;
		this.managePassword = managePassword;
		this.manageName = manageName;
		this.manageAuthority = manageAuthority;
	}
	public String getmanageId() {
		return manageId;
	}


	public void setmanageId(String manageId) {
		this.manageId = manageId;
	}


	

	public String getmanagePassword() {
		return managePassword;
	}


	public void setmanagePassword(String managePassword) {
		this.managePassword = managePassword;
	}
	public String getmanageName() {
		return manageName;
	}


	public void setmanageName(String manageName) {
		this.manageName = manageName;
	}





	public String getmanageAuthority() {
		return manageAuthority;
	}


	public void setmanageAuthority(String manageAuthority) {
		this.manageAuthority = manageAuthority;
	}
	
}
