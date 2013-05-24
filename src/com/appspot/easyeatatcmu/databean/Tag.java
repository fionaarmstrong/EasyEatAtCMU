package com.appspot.easyeatatcmu.databean;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Tag database table.
 * 
 */
@Entity
@Table(name = "Tag")
@NamedQueries({
    @NamedQuery(name = "Tag.findAll", query = "SELECT c FROM Tag c ORDER BY c.tagid")})
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tagid;

	private String tagname;
	private String tagdesc;

	//bi-directional many-to-many association to Post
	@ManyToMany
	@JoinTable(
		name="PostTag"
		, joinColumns={
			@JoinColumn(name="tagid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="postid")
			}
		)
	private List<Post> posts;

	public Tag() {
	}

	public int getTagid() {
		return this.tagid;
	}

	public void setTagid(int tagid) {
		this.tagid = tagid;
	}

	public String getTagname() {
		return this.tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getTagdesc() {
		return tagdesc;
	}

	public void setTagdesc(String tagdesc) {
		this.tagdesc = tagdesc;
	}

}