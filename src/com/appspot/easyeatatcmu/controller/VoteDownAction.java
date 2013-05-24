package com.appspot.easyeatatcmu.controller;



import com.appspot.easyeatatcmu.databean.Post;
import com.appspot.easyeatatcmu.databean.Vote;
import com.appspot.easyeatatcmu.model.PostService;
import com.appspot.easyeatatcmu.model.VoteService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * when an user clicked vote down.
 * 1. cancel the vote down that already made.
 * 2. add a vote down
 * @author Yin Xu
 *
 */

public class VoteDownAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int postid;
	private int userid;

	/**
	 * flag is used to determine to add 1 or cancel current vote down.
	 */
	
	private int flag;
	
	
	public String execute(){
		//User user = (User) session.get("user");
//		if(user == null){
//			return LOGIN;
//		}
		//if userid = 0, redirect to login
		System.out.println("userid is "+userid);
		System.out.println("postid is "+postid);
		VoteService vs = new VoteService();
		PostService ps = new PostService();
		Vote downVote = vs.voteLookup(userid, postid, "down");
		/**
		 * get the post to which the vote belong
		 */
		Post post = ps.getPostById(postid);
		if(downVote == null){
			/**
			 * if an user hasn't voted for this post
			 */
			System.out.println("no down vote found");
			downVote = new Vote();
			downVote.setUserid(userid);
			downVote.setUpdown("down");
			
			downVote.setPost(post);
			vs.createVote(downVote);
			/**
			 * check if the user has voted up the post.
			 * if has, set flag to 2.
			 */
			Vote upVote = vs.voteLookup(userid, postid, "up");
			if(upVote == null){
				/**
				 * hasn't voted up
				 */
				System.out.println("no up vote found");
				flag = 1;
				ps.modifyPopularity(postid, -1);
			}else{
				/**
				 * delete the vote up record first
				 */
				System.out.println("found up vote");
				vs.deleteVote(userid, postid, "up");
				flag = 2;
				ps.modifyPopularity(postid, -2);
			}
		}	
		else{
			/**
			 * cancel the vote down that already made
			 */
			System.out.println("found down vote");
			vs.deleteVote(userid, postid, "down");
			flag = -1;
			ps.modifyPopularity(postid, 1);
		}
		
		return SUCCESS;
	}

	public int getPostid() {
		return postid;
	}
	
	public void setPostid(int postid) {
		this.postid = postid;
	}

	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
