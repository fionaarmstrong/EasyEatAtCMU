package com.appspot.easyeatatcmu.databean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PostTag database table.
 * 
 */
@Entity
@Table(name = "PostTag")

public class PostTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int postid;
	
	private int tagid;

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public int getTagid() {
		return tagid;
	}

	public void setTagid(int tagid) {
		this.tagid = tagid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postid;
		result = prime * result + tagid;
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
		PostTag other = (PostTag) obj;
		if (postid != other.postid)
			return false;
		if (tagid != other.tagid)
			return false;
		return true;
	}

	

}