package com.appspot.easyeatatcmu.databean;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Restaurant database table.
 * 
 */
@Entity
@Table(name = "Restaurant")

public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int restid;

	private String address;

	private String name;

	//bi-directional many-to-one association to Post
	//@OneToMany(mappedBy="restaurant")
	private List<Post> posts;

	public Restaurant() {
	}

	public int getRestid() {
		return this.restid;
	}

	public void setRestid(int restid) {
		this.restid = restid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}