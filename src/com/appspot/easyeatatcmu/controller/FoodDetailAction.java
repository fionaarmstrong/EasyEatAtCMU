package com.appspot.easyeatatcmu.controller;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.appspot.easyeatatcmu.databean.Comment;
import com.appspot.easyeatatcmu.databean.Post;
import com.appspot.easyeatatcmu.databean.Tag;
import com.appspot.easyeatatcmu.databean.User;
import com.appspot.easyeatatcmu.databean.Vote;
import com.appspot.easyeatatcmu.model.CommentService;
import com.appspot.easyeatatcmu.model.PostService;
import com.appspot.easyeatatcmu.model.VoteService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * This class displays the detail info about the post.
 * @author Yin Xu
 *
 */
public class FoodDetailAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private Map session;
	/**
	 * postid: the post which is selectd.
	 */
	private int postid;
	private Post post;
	private int numUpVote;
	private int numDownVote;
	private int numComment;
	private String mapSrc;
	private User user;
	private List<Comment> commentList;
	private Post similarPost;
	private int hasSimilar;
	private int page;
	private int flag;
	
	public String execute(){
		user = (User) session.get("user");
		if(user == null){
			return LOGIN;
		}
		int userid = user.getUserid();
		/**
		 * all about post
		 */
		PostService ps = new PostService();
		post = ps.getPostById(postid);

		/**
		 * all about PostTag
		 * recommend a similar post
		 */
		List<Tag> tagList = post.getTags();
		
		if(tagList.size() != 0){
			List<Post> pList = null;
			for (int j = 0; j < tagList.size(); j++) {
				pList = tagList.get(j).getPosts();
				System.out.println(pList.size());
				/**
				 * remove the post itself from the list first
				 */
				pList.remove(post);
				System.out.println(pList.size());
				if(pList.size() == 0)
					continue;
				int i = 1;
				while(pList.size() != 0 && i < tagList.size()){
					/**
					 * store the first element in the list as a potential result
					 */
					similarPost = pList.get(0);
					pList = ps.filterPostList(tagList.get(i), pList);
					i++;
				}
				if(similarPost != null)
					hasSimilar = 1;
				else
					hasSimilar = 0;
				break;
			}
			//System.out.println(similarPost.getTitle());
		}
		
		/**
		 * all about vote
		 */
		VoteService vs = new VoteService();
		numUpVote = vs.getNumVote(postid, "up");
		numDownVote = vs.getNumVote(postid, "down");

		flag = 0;
		Vote upVote = vs.voteLookup(userid, postid, "up");
		Vote downVote = vs.voteLookup(userid, postid,"down");
		if (upVote != null) {
			/**
			 * voted up before
			 */
			flag = 1;
		}
		if (downVote != null) {
			/**
			 * voted down before
			 */
			flag = 2;
		}
		//System.out.println(flag);
		/**
		 * all about comment
		 */
		CommentService cs = new CommentService();
		commentList = cs.getCommentById(postid,page);
		if(commentList.size() == 0){
			numComment = 0;
		}
		else{
			numComment = commentList.size();
		}
		
		/**
		 * generate the google map source
		 */
		String loc = post.getLocation();
		loc = loc.replace(" ", "+");
		mapSrc = "http://maps.googleapis.com/maps/api/staticmap?center="+loc
				+",Pittsburgh,PA&zoom=15&size=280x220&maptype=roadmap&markers=color:blue%7Clabel:S%7C"
				+loc+",Pittsburgh,PA&sensor=false";
		
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

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getNumUpVote() {
		return numUpVote;
	}

	public void setNumUpVote(int numUpVote) {
		this.numUpVote = numUpVote;
	}

	public int getNumDownVote() {
		return numDownVote;
	}

	public void setNumDownVote(int numDownVote) {
		this.numDownVote = numDownVote;
	}

	public int getNumComment() {
		return numComment;
	}

	public void setNumComment(int numComment) {
		this.numComment = numComment;
	}

	public String getMapSrc() {
		return mapSrc;
	}

	public void setMapSrc(String mapSrc) {
		this.mapSrc = mapSrc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	/**
	 * @return the similarPost
	 */
	public Post getSimilarPost() {
		return similarPost;
	}

	/**
	 * @param similarPost the similarPost to set
	 */
	public void setSimilarPost(Post similarPost) {
		this.similarPost = similarPost;
	}

	public int getHasSimilar() {
		return hasSimilar;
	}

	public void setHasSimilar(int hasSimilar) {
		this.hasSimilar = hasSimilar;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
