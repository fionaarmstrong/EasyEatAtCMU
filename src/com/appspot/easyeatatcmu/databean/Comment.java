package com.appspot.easyeatatcmu.databean;

import java.util.Date;

import javax.persistence.*;


/**
 * 
 * @author remonx
 *
 */

@Entity
@Table(name = "Comment")
//@NamedQueries({
//    @NamedQuery(name = "Comment.findByUserid", query = "SELECT c FROM Comment c WHERE c.userid = :userid")})

public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comid;

	//bi-directional many-to-one association to Post
	@ManyToOne
	@JoinColumn(name="postid")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	@Basic(optional = false)
	@Column(name = "createtime", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;
	
	@Lob
	@Column(name = "content")
	private String content; 
	
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + comid;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (comid != other.comid)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	} 
	
	
	
}
