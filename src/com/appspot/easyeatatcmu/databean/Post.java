package com.appspot.easyeatatcmu.databean;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Post database table.
 * 
 */
@Entity
@Table(name = "Post")

public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postid;
	
	private int popularity;

	private String category;

	private Timestamp createtime;

	@Lob
	private String description;

	private String photolink;

	private String price;

	private String title;
	
	private String restaurant;
	
	private String location;

	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="post")
	private List<Comment> comments;

	//bi-directional many-to-one association to Restaurant
//	@ManyToOne
//	@JoinColumn(name="restid")
//	private Restaurant restaurant;

	//bi-directional many-to-many association to Tag
	@ManyToMany(mappedBy="posts")
	private List<Tag> tags;

	//bi-directional many-to-one association to Vote
	@OneToMany(mappedBy="post")
	private List<Vote> votes;

	public Post() {
	}

	public int getPostid() {
		return this.postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotolink() {
		return this.photolink;
	}

	public void setPhotolink(String photolink) {
		this.photolink = photolink;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public List<Tag> getTags() {
		return this.tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Vote> getVotes() {
		return this.votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postid;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (postid != other.postid)
			return false;
		return true;
	}
	

}