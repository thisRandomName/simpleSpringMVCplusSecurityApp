package proj.crudspringmvcplussecurity.model;

//public enum UserProfileType {

import java.io.Serializable;

public enum UserProfileType implements Serializable{
	USER("USER"),
	TEACHER("TEACHER"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
