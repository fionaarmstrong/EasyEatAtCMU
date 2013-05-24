package com.appspot.easyeatatcmu.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.appspot.easyeatatcmu.databean.User;
import com.opensymphony.xwork2.ActionSupport;

public class SignOutAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 113133131L;
	
	@SuppressWarnings("rawtypes")
	private Map session;
	
	public String execute(){
		
		//System.out.println("logout executed");
		User user = (User) session.get("user");
		System.out.println(user.getEmail());
		session.remove("user");
		//session.put("user", null);
		return SUCCESS;
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
