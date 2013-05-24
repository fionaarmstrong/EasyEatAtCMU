package com.appspot.easyeatatcmu.controller;

import java.util.ArrayList;
import java.util.List;

import com.appspot.easyeatatcmu.databean.Comment;
import com.appspot.easyeatatcmu.databean.Post;
import com.appspot.easyeatatcmu.databean.PostTag;
import com.appspot.easyeatatcmu.databean.Tag;
import com.appspot.easyeatatcmu.databean.Vote;
import com.appspot.easyeatatcmu.model.CommentService;
import com.appspot.easyeatatcmu.model.PostService;
import com.appspot.easyeatatcmu.model.PostTagService;
import com.appspot.easyeatatcmu.model.TagService;
import com.appspot.easyeatatcmu.model.VoteService;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	
	public String execute(){
		PostService ps = new PostService();
		Post post = ps.getPostById(1);
		System.out.println(post.getTitle());
		
		Comment comment = new Comment();
		comment.setUser(null);
		comment.setPost(post);
		comment.setContent("haha");
		CommentService cs = new CommentService();
		cs.createComment(comment);
		
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getTitle());
//		}
//		if(vote==null)
//			System.out.println("nullllll");
//		else
//			System.out.println("has something....");
		
//		String t = "Fish";
//		int test = ts.createTag(t);
//		System.out.println(test);
		
		return SUCCESS;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
