package com.appspot.easyeatatcmu.databean;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

import javax.persistence.*;

/**
 * 
 * @author Yin Xu
 *
 */
@Entity
@Table(name = "User")
@NamedQueries({
    @NamedQuery(name = "User.findByEmail", query = "SELECT c FROM User c WHERE c.email = :email")})
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String email;
	private String firstname;
	private String lastname;
	private String hashedpassword;
	private int salt;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> commentList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> postList;
	
	
	public User(){}
	/*
	 * set the salt first.
	 */
	public User(String fn, String ln, String email, String pwd){
		salt = newSalt();
		this.email = email;
		firstname = fn;
		lastname = ln;
		hashedpassword = hash(pwd);
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getHashedpassword() {
		return hashedpassword;
	}
	public void setHashedpassword(String hashedpassword) {
		this.hashedpassword = hashedpassword;
	}
	public int getSalt() {
		return salt;
	}
	public void setSalt(int salt) {
		this.salt = salt;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	
	/*
	 * functional methods
	 */
	public boolean checkPassword(String password) {
		return hashedpassword.equals(hash(password));
	}
	private String hash(String clearPassword) {
		if (salt == 0) return null;

		MessageDigest md = null;
		try {
		  md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {
		  throw new AssertionError("Can't find the SHA1 algorithm in the java.security package");
		}

		String saltString = String.valueOf(salt);
		
		md.update(saltString.getBytes());
		md.update(clearPassword.getBytes());
		byte[] digestBytes = md.digest();

		// Format the digest as a String
		StringBuffer digestSB = new StringBuffer();
		for (int i=0; i<digestBytes.length; i++) {
		  int lowNibble = digestBytes[i] & 0x0f;
		  int highNibble = (digestBytes[i]>>4) & 0x0f;
		  digestSB.append(Integer.toHexString(highNibble));
		  digestSB.append(Integer.toHexString(lowNibble));
		}
		String digestStr = digestSB.toString();

		return digestStr;
	}

	private int newSalt() {
		Random random = new Random();
		return random.nextInt(8192)+1;  // salt cannot be zero
	}

}
