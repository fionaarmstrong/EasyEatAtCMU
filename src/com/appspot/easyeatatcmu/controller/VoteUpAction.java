package com.appspot.easyeatatcmu.controller;


import com.appspot.easyeatatcmu.databean.Post;
import com.appspot.easyeatatcmu.databean.Vote;
import com.appspot.easyeatatcmu.model.PostService;
import com.appspot.easyeatatcmu.model.VoteService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * when an user clicked vote up.
 * 1. cancel the vote up that already made.
 * 2. add a vote up
 * @author Yin Xu
 *
 */
public class VoteUpAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int postid;
	private int userid;

	/**
	 * flag is used to determine to add 1 or cancel current voteup.
	 */
	private int flag;
	
	
	public String execute(){
//		User user = (User) session.get("user");
//		if(user == null){
//			return LOGIN;
//		}
		
		VoteService vs = new VoteService();
		PostService ps = new PostService();
		Vote upVote = vs.voteLookup(userid, postid, "up");
		/**
		 * get the post to which the vote belong
		 */
		Post post = ps.getPostById(postid);
		//System.out.println(popularity);
		if(upVote == null){
			/**
			 * if an user hasn't voted for this post
			 */
			upVote = new Vote();
			upVote.setUserid(userid);
			upVote.setUpdown("up");
		
			upVote.setPost(post);
			vs.createVote(upVote);
			/**
			 * check if the user has voted down the post.
			 * if has, set flag to 2.
			 */
			Vote downVote = vs.voteLookup(userid, postid, "down");
			if(downVote == null){
				/**
				 * hasn't voted down
				 */
				flag = 1;
				
				ps.modifyPopularity(postid, 1);
			}
			else{
				/**
				 * delete the vote down record first
				 */
				vs.deleteVote(userid, postid, "down");
				flag = 2;
				ps.modifyPopularity(postid, 2);
			}
		}	
		else{
			/**
			 * cancel the vote up that already made
			 */
			vs.deleteVote(userid, postid, "up");
			flag = -1;
			ps.modifyPopularity(postid, -1);
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
