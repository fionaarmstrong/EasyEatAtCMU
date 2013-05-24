package com.appspot.easyeatatcmu.databean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Vote database table.
 * 
 */
@Entity
@Table(name = "Vote")

public class Vote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int voteid;

	private String updown;

	private int userid;

	//bi-directional many-to-one association to Post
	@ManyToOne
	@JoinColumn(name="postid")
	private Post post;

	public Vote() {
	}

	public int getVoteid() {
		return this.voteid;
	}

	public void setVoteid(int voteid) {
		this.voteid = voteid;
	}

	public String getUpdown() {
		return this.updown;
	}

	public void setUpdown(String updown) {
		this.updown = updown;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}