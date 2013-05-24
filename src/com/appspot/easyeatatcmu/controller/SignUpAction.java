package com.appspot.easyeatatcmu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.appspot.easyeatatcmu.databean.User;
import com.appspot.easyeatatcmu.model.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * User registration
 * @author Yin Xu
 *
 */
public class SignUpAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String emailSignUp;
	private String pwdSignUp;
	private List<String> errorList;
	@SuppressWarnings("rawtypes")
	private Map session;
	
	@SuppressWarnings("unchecked")
	public String execute(){
		errorList = new ArrayList<String>();
		UserService us = new UserService();
		if(firstName.equals("") || firstName == null){
			errorList.add("name can't be null.");
		}
		if(errorList.size() != 0){
			return LOGIN;
		}
		if(emailSignUp.equals("") || emailSignUp == null){
			errorList.add("email can't be null.");
		}
		if(errorList.size() != 0){
			return LOGIN;
		}
		if(pwdSignUp.equals("") || pwdSignUp == null){
			errorList.add("password can't be null.");
		}
		if(errorList.size() != 0){
			return LOGIN;
		}
		User user = new User(firstName, lastName, emailSignUp, pwdSignUp);
		try{
		us.createUser(user);
		}catch(Exception e){
			//System.out.println("email used. "+e.getMessage());
			errorList.add("you already sign up before. Try login again.");
			return LOGIN;
		}
		session.put("user", user);
		return SUCCESS;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailSignUp() {
		return emailSignUp;
	}

	public void setEmailSignUp(String emailSignUp) {
		this.emailSignUp = emailSignUp;
	}

	public String getPwdSignUp() {
		return pwdSignUp;
	}

	public void setPwdSignUp(String pwdSignUp) {
		this.pwdSignUp = pwdSignUp;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}
	

}
