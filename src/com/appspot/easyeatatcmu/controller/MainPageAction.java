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
 * Posts list for main page
 * generate n random posts for the slider
 * @author Yin Xu
 *
 */
public class MainPageAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private List<Post> postList;
	@SuppressWarnings("rawtypes")
	private Map session;
	private int flagArray[];
	private int totalPosts;
	private int totalUsers;
	private String category;
	private List<Post> sliderList;
	private String currTab;
	private int page;
	private List<Tag> popularTagList;
	private int totalLovePosts;
	private int totalHatePosts;
	//
	private User user;

	public String execute(){
		
		user = (User) session.get("user");
		if(user == null){
			return LOGIN;
		}
		int userid = user.getUserid();
		System.out.println(userid);
		
		/**
		 * initialize posts in the main page
		 */
		PostService ps = new PostService();
		VoteService vs = new VoteService();
		/**
		 * Read top 5 popular posts
		 */
		if(category == null){
			category = "Love";
		}
		
		/**
		 * set the current tab page (name ony)
		 */
		if(currTab == null){
			currTab = "Top";
		}
		
		/**
		 * fetch post list according to tab
		 */
		if(currTab.equals("Contro"))
			postList = vs.getControPosts(page, 15, category);
		else if(currTab.equals("New"))
			postList = ps.getNewPosts(page, category);
		else
			postList = ps.getPopularPosts(page, category);
//		/**
//		 * Read 5 newest posts
//		 */
//		newPostList = ps.getNewPosts(0, "Love");
		
		/**
		 * load flag to determine the color of vote buttons.
		 */
		
		//hot
		flagArray = new int[postList.size()];
		int hotFlag = 0;
		for(int i=0;i< postList.size();i++){
			hotFlag = 0;
			Vote upVote = vs.voteLookup(userid, postList.get(i).getPostid(), "up");
			Vote downVote = vs.voteLookup(userid, postList.get(i).getPostid(), "down");
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
			flagArray[i] = hotFlag;
			//System.out.println(hotFlag);
		}
		
		/**
		 * get the total number of Posts
		 */
		totalPosts = ps.totalPosts();
		/**
		 * get the total number of users who posted food before
		 */
		totalUsers = ps.totalUsers();
		
		/**
		 * generate n random posts
		 */
		sliderList = ps.randPosts(totalPosts, 5);
		
		/**
		 * generate n popular tags
		 */
		PostTagService pts = new PostTagService();
		popularTagList = pts.getPopularTags(10);
		//System.out.println("popular tag has "+popularTagList.size());
		
		/**
		 * set the total love posts
		 */
		totalLovePosts = ps.totalPostsByCategory("Love");
		totalHatePosts = ps.totalPostsByCategory("Hate");

		return SUCCESS;
	}


	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	public int[] getFlagArray() {
		return flagArray;
	}

	public void setFlagArray(int[] flagArray) {
		this.flagArray = flagArray;
	}


	public int getTotalPosts() {
		return totalPosts;
	}


	public void setTotalPosts(int totalPosts) {
		this.totalPosts = totalPosts;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public List<Post> getSliderList() {
		return sliderList;
	}


	public void setSliderList(List<Post> sliderList) {
		this.sliderList = sliderList;
	}


	public String getCurrTab() {
		return currTab;
	}


	public void setCurrTab(String currTab) {
		this.currTab = currTab;
	}


	public int getTotalUsers() {
		return totalUsers;
	}


	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public List<Tag> getPopularTagList() {
		return popularTagList;
	}


	public void setPopularTagList(List<Tag> popularTagList) {
		this.popularTagList = popularTagList;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public int getTotalLovePosts() {
		return totalLovePosts;
	}


	public void setTotalLovePosts(int totalLovePosts) {
		this.totalLovePosts = totalLovePosts;
	}


	public int getTotalHatePosts() {
		return totalHatePosts;
	}


	public void setTotalHatePosts(int totalHatePosts) {
		this.totalHatePosts = totalHatePosts;
	}
	
}
