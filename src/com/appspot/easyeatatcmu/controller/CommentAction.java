package com.appspot.easyeatatcmu.controller;



import com.appspot.easyeatatcmu.databean.Comment;
import com.appspot.easyeatatcmu.databean.Post;
import com.appspot.easyeatatcmu.databean.User;
import com.appspot.easyeatatcmu.model.CommentService;
import com.appspot.easyeatatcmu.model.PostService;
import com.appspot.easyeatatcmu.model.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * This class add a new comment into database.
 * @author Yin Xu
 *
 */
public class CommentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String content;
	private int postid;
	private int userid;
	
	public String execute(){
		//User user = (User) session.get("user");
		UserService us = new UserService();
		User user = us.getUser(userid);
		PostService ps = new PostService();
		Post post = ps.getPostById(postid);
		Comment comment = new Comment();
		comment.setUser(user);
		comment.setPost(post);
		comment.setContent(content);
		CommentService cs = new CommentService();
		cs.createComment(comment);
		
		return SUCCESS;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
