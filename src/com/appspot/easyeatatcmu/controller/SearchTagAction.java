package com.appspot.easyeatatcmu.controller;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.appspot.easyeatatcmu.databean.Post;
import com.appspot.easyeatatcmu.databean.Tag;
import com.appspot.easyeatatcmu.databean.User;
import com.appspot.easyeatatcmu.model.PostTagService;
import com.appspot.easyeatatcmu.model.TagService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * this class list the post of a specific tag.
 * @author Yin Xu
 *
 */
public class SearchTagAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private Map session;
	private int tagid;
	private List<Post> resultList;
	private String searchkey;
	private List<Tag> popularTagList;
	
	public String execute(){
		User user = (User) session.get("user");
		if(user == null){
			return LOGIN;
		}
		
		TagService ts = new TagService();
		Tag tag = ts.getTagById(tagid);
		searchkey = tag.getTagname();
		resultList = tag.getPosts();
		
		/**
		 * get the popular tags for side bar
		 */
		PostTagService pts = new PostTagService();
		popularTagList = pts.getPopularTags(10);
		
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

	public int getTagid() {
		return tagid;
	}

	public void setTagid(int tagid) {
		this.tagid = tagid;
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

	public List<Tag> getPopularTagList() {
		return popularTagList;
	}

	public void setPopularTagList(List<Tag> popularTagList) {
		this.popularTagList = popularTagList;
	}

}
