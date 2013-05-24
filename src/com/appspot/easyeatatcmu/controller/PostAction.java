package com.appspot.easyeatatcmu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.appspot.easyeatatcmu.databean.Post;
import com.appspot.easyeatatcmu.databean.Tag;
import com.appspot.easyeatatcmu.databean.User;
import com.appspot.easyeatatcmu.model.PostService;
import com.appspot.easyeatatcmu.model.PostTagService;
import com.appspot.easyeatatcmu.model.TagService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * post a new food
 * @author Yin Xu
 *
 */
public class PostAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String price;
	private String restaurant;
	private String location;
	private String tags;
	private String photolink;
	private String description;
	private String category;
	private List<String> errorList;
	@SuppressWarnings("rawtypes")
	private Map session;
	private List<Tag> tagList;
	
	public String execute(){
		//check if logged in
		errorList = new ArrayList<String>();
		User user = (User) session.get("user");
		if(user == null){
			errorList.add("log in first");
			return LOGIN;
		}
		TagService ts = new TagService();
		tagList = ts.listTags();
		//check null input
		if (title == null || title.length() == 0){
			errorList.add("You must provide a title");
		}
		if (description == null || description.length() == 0){
			errorList.add("You must provide description");
		}
		if (price == null || price.length() == 0){
			errorList.add("You must provide price");
		}
		if (restaurant == null || restaurant.length() == 0){
			errorList.add("You must provide restaurant");
		}
		
		if (photolink == null || photolink.length() == 0){
			/*
			 * if an user didn't provide a photo
			 * use a default one.
			 */
			photolink = "http://i.imgur.com/NMLpcKj.jpg";
		}
		else{
			/*
			 * concatenate photo link
			 */
			photolink = conPhotoLink(photolink);
		}
		
		/**
		 * if error detected, return to post page.
		 */
		if(errorList.size() != 0){
			return ERROR;
		}
		
		PostService ps = new PostService();
		Post post = new Post();
		post.setTitle(trimAndConvert(title,"<>\""));
		post.setPrice(price);
		post.setRestaurant(trimAndConvert(restaurant,"<>\""));
		post.setLocation(trimAndConvert(location,"<>\""));
		post.setDescription(trimAndConvert(description,"<>\""));
		post.setCategory(category);	
		post.setPhotolink(photolink);
		post.setUser(user);
		int pid = ps.createPost(post);
		
		/*
		 * store tags into database
		 */
		tags = trimAndConvert(tags,"<>\"");
		if(!(tags == null || tags.length() == 0)){
			PostTagService pts = new PostTagService();
			/*
			 * parse the tags string into string array
			 */
			String[] tagArray =  tags.split(",");
			int[] tagIdArray = ts.insertTagArray(tagArray);
			for(int i=0;i<tagIdArray.length;i++){
				
				if(tagIdArray[i] > 0){
					/*
					 * >0 means a valid tag value
					 */
					pts.createPostTag(pid, tagIdArray[i]);
				}
			}
			
			
		}
		
		System.out.println(photolink);
		System.out.println(tags);
		
		return SUCCESS;
	}
	
	/**
	 * concatenate photo link
	 * original :http://imgur.com/eYXznFM
	 * need: http://i.imgur.com/iIlPkLs.jpg 
	 */
	public String conPhotoLink(String link){
		String photolink = "http://i.imgur.com/";
		String addr = link.substring(17);
		photolink = photolink.concat(addr).concat(".jpg");
		return photolink;
	}
	
	/**
	 * Sanitize user input.
	 * This method is taken from FormBeanFactory
	 * @param s
	 * @param charsToConvert
	 * @return
	 */
	public String trimAndConvert(String s, String charsToConvert) {
		if (!s.matches(".*["+charsToConvert+"].*")) {
			return s.trim();
		}
		
		StringBuffer b = new StringBuffer();
		for (char c : s.trim().toCharArray()) {
			switch (c) {
				case '<':
					if (charsToConvert.indexOf('<') != -1) {
						b.append("&lt;");
					} else {
						b.append(c);
					}
					break;
				case '>':
					if (charsToConvert.indexOf('>') != -1) {
						b.append("&gt;");
					} else {
						b.append(c);
					}
					break;
				case '&':
					if (charsToConvert.indexOf('&') != -1) {
						b.append("&amp;");
					} else {
						b.append(c);
					}
					break;
				case '"':
					if (charsToConvert.indexOf('"') != -1) {
						b.append("&quot;");
					} else {
						b.append(c);
					}
					break;
				default:
					if (charsToConvert.indexOf(c) != -1) {
						b.append("&#"+c+";");
					} else {
						b.append(c);
					}
			}
		}
		
		return b.toString();
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhotolink() {
		return photolink;
	}

	public void setPhotolink(String photolink) {
		this.photolink = photolink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	
}
