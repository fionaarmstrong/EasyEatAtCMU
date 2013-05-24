package com.appspot.easyeatatcmu.controller;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.appspot.easyeatatcmu.databean.Post;
import com.appspot.easyeatatcmu.databean.Tag;
import com.appspot.easyeatatcmu.databean.User;
import com.appspot.easyeatatcmu.databean.Vote;
import com.appspot.easyeatatcmu.model.PostService;
import com.appspot.easyeatatcmu.model.PostTagService;
import com.appspot.easyeatatcmu.model.VoteService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * this class performs the search operation
 * @author Yin Xu
 *
 */
public class SearchPostAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Post> resultList;
	private String searchkey;
	@SuppressWarnings("rawtypes")
	private Map session;
	private int resultFlagArray[];
	private List<Tag> popularTagList;
	private int totalPosts;
	private int totalUsers;
	
	public String execute(){
		User user = (User) session.get("user");
		if(user == null){
			return LOGIN;
		}
		int userid = user.getUserid();
		PostService ps = new PostService();
		resultList = ps.search(searchkey);
		
		/**
		 * load flag to determine the color of vote buttons.
		 */
		VoteService vs = new VoteService();
		//hot
		resultFlagArray = new int[resultList.size()];
		int hotFlag = 0;
		for(int i=0;i< resultList.size();i++){
			hotFlag = 0;
			Vote upVote = vs.voteLookup(userid, resultList.get(i).getPostid(), "up");
			Vote downVote = vs.voteLookup(userid, resultList.get(i).getPostid(), "down");
			if(upVote != null){
				/**
				 * voted up before
				 */
				hotFlag = 1;
			}
			if(downVote != null){
				/**
				 * voted down before
				 */
				hotFlag = 2;
			}
			//hotFlagList.add(hotFlag);
			resultFlagArray[i] = hotFlag;
		}
		
		/**
		 * get the popular tags for side bar
		 */
		PostTagService pts = new PostTagService();
		popularTagList = pts.getPopularTags(10);
		
		/**
		 * get the total number of Posts
		 */
		totalPosts = ps.totalPosts();
		/**
		 * get the total number of users who posted food before
		 */
		totalUsers = ps.totalUsers();
		
		return SUCCESS;
	}

	public List<Post> getResultList() {
		return resultList;
	}

	public void setResultList(List<Post> resultList) {
		this.resultList = resultList;
	}

	public String getSearchkey() {
		return searchkey;
	}

	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	public int[] getResultFlagArray() {
		return resultFlagArray;
	}

	public void setResultFlagArray(int[] resultFlagArray) {
		this.resultFlagArray = resultFlagArray;
	}

	public List<Tag> getPopularTagList() {
		return popularTagList;
	}

	public void setPopularTagList(List<Tag> popularTagList) {
		this.popularTagList = popularTagList;
	}

	public int getTotalPosts() {
		return totalPosts;
	}

	public void setTotalPosts(int totalPosts) {
		this.totalPosts = totalPosts;
	}

	public int getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}
	
}
