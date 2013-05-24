package com.appspot.easyeatatcmu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.appspot.easyeatatcmu.model.UserService;
import com.appspot.easyeatatcmu.databean.User;

public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String emailSignIn;
	private String pwdSignIn;
	@SuppressWarnings("rawtypes")
	private Map session;
	private List<String> errorList;
	
	@SuppressWarnings("unchecked")
	public String execute(){
		errorList = new ArrayList<String>();
		UserService us = new UserService();
		User user = (User) session.get("user");
		if(user != null){
			//errorList.add("You are already logged in");
			System.out.println("already login");
			return SUCCESS;
		}
		user = us.getUserByEmail(emailSignIn); //TO-DO: change id to email.
		if(user == null && emailSignIn != null){
			errorList.add("Email Address doesn't exist");
			return LOGIN;
		}
		if (user != null && !user.checkPassword(pwdSignIn)) {
    		errorList.add("Incorrect password");
    		return LOGIN;
    	}
		
		session.put("user", user);
		
		return SUCCESS;
	}

	public String getEmailSignIn() {
		return emailSignIn;
	}

	public void setEmailSignIn(String emailSignIn) {
		this.emailSignIn = emailSignIn;
	}

	public String getPwdSignIn() {
		return pwdSignIn;
	}

	public void setPwdSignIn(String pwdSignIn) {
		this.pwdSignIn = pwdSignIn;
	}

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errors) {
		this.errorList = errors;
	}
	

}
