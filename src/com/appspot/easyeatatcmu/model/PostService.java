package com.appspot.easyeatatcmu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.appspot.easyeatatcmu.databean.*;

/**
 * DAO for Post bean
 * @author remonx
 *
 */
public class PostService {
	private static Logger logger = Logger.getLogger(PostService.class.getName());
	
	/**
	 * create a Post - with persistencce
	 */
	public int createPost(Post c){
		logger.info("Entering createPost: [" 
                + c.getTitle() + "]");
		EntityManager em = EMF.get().createEntityManager();
		try {
            em.getTransaction().begin();
            em.persist(c);
            //em.flush();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        logger.info("Exiting createPost");
        System.out.println(c.getPostid());
        return c.getPostid();
	}
	
	/**
     * Gets a Post given an userid
     * @param id
     * @return Post bean List
     */
   
	@SuppressWarnings("unchecked")
	public List<Post> getPost(int userid) {
        logger.info("Entering getPost[" + userid + "]");
        List<Post> result = null;
        EntityManager em = EMF.get().createEntityManager();
        try {
        	Query q = em.createQuery("SELECT c FROM Post c WHERE c.user.userid = :userid");
        	q.setParameter("userid", userid);
            result = (List<Post>)q.getResultList();
        } finally {
            em.close();
        }
        if (result == null) {
            logger.warning("No Posts returned");
        }
        logger.info("Exiting getPost");
        return result;
    }
	
	/**
     * Gets a Post given an postid
     * @param id
     * @return Post bean
     */
	
	public Post getPostById(int postid) {
        logger.info("Entering getPost[" + postid + "]");
        EntityManager em = EMF.get().createEntityManager();
        Post post = null;
        try {
        	post = em.find(Post.class, postid);
        } finally {
            em.close();
        }
        logger.info("Exiting getPost");
        return post;
    }
	
	/**
	 * given an index, list first 15 popular posts.
	 */
	@SuppressWarnings("unchecked")
	public List<Post> getPopularPosts(int index,String category){
		logger.info("Entering getPopularPosts[" + index + "]");
        List<Post> result = null;
        EntityManager em = EMF.get().createEntityManager();
        try {
        	Query q = em.createQuery("SELECT c FROM Post c WHERE c.category = :category" +
        			" ORDER BY c.popularity DESC");
        	q.setParameter("category", category);
            result = (List<Post>)q.setFirstResult(index*15).setMaxResults(15).getResultList();
        } finally {
            em.close();
        }
        if (result == null) {
            logger.warning("No Posts returned");
        }
        logger.info("Exiting getPopularPosts");
        return result;
	}
	
	/**
	 * given an index, list 15 newest posts.
	 */
	@SuppressWarnings("unchecked")
	public List<Post> getNewPosts(int index,String category){
		logger.info("Entering getNewPosts[" + index + "]");
        List<Post> result = null;
        EntityManager em = EMF.get().createEntityManager();
        try {
        	Query q = em.createQuery("SELECT c FROM Post c WHERE c.category = :category" +
        			" ORDER BY c.createtime DESC");
        	q.setParameter("category", category);
            result = (List<Post>)q.setFirstResult(index*15).setMaxResults(15).getResultList();
        } finally {
            em.close();
        }
        if (result == null) {
            logger.warning("No Posts returned");
        }
        logger.info("Exiting getNewPosts");
        return result;
	}
	/**
     * Modify the popularity given an Post and offset
     * @param id
     * @return Post bean
     */
	public void modifyPopularity(int postid, int offset) {
        logger.info("Entering modifyPopularity["  + "]");
        EntityManager em = EMF.get().createEntityManager();
        Post post = em.find(Post.class, postid);
        int popularity = post.getPopularity() + offset;
        System.out.println(popularity);
        try {
        	em.getTransaction().begin();
            post.setPopularity(popularity);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        logger.info("Exiting modifyPopularity");
    }
	
	/**
	 * Search for posts that contains the provided keywords.
	 * the fields are title, description.
	 * the result is sorted by popularity.
	 * query example:
	 * Select * from Post where upper(description) like upper('%sweet%') OR upper(title) like upper('%bbq%');
	 */
	@SuppressWarnings("unchecked")
	public List<Post> search(String keyword){
		logger.info("Entering search[" + keyword + "]");
        List<Post> result = null;
        EntityManager em = EMF.get().createEntityManager();
        try {
        	Query q = em.createQuery("SELECT c FROM Post c WHERE upper(c.description) like upper(:keyword)" +
        			"OR upper(c.title) like upper(:keyword) order by c.popularity desc");
        	q.setParameter("keyword", "%"+keyword+"%");
            result = (List<Post>)q.setFirstResult(0).setMaxResults(15).getResultList();
        } finally {
            em.close();
        }
        if (result == null) {
            logger.warning("No Posts returned");
        }
        logger.info("Exiting getNewPosts");
        return result;
	}
	
	/**
	 * given a tag and a post list, select posts that contain the tag
	 */
	public List<Post> filterPostList(Tag tag, List<Post> list){
		logger.info("Entering filterPostList[]");
        List<Post> result = new ArrayList<Post>();
        for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getTags().contains(tag)){
				result.add(list.get(i));
			}
		}
        logger.info("Exiting filterPostList");
        return result;
	}
	
	/**
	 * return the total number of Posts.
	 */
	@SuppressWarnings("unchecked")
	public int totalPosts(){
		logger.info("Entering totalPosts");
		EntityManager em = EMF.get().createEntityManager();
		List<Object> results;
		int count = 0;
		try {
			Query q = em.createQuery("SELECT COUNT(c.postid) FROM Post c");
            results =q.getResultList();
            count = ((Number) results.get(0)).intValue();
        } finally {
            em.close();
        }
        logger.info("Exiting tagStat");
        return count;
	}
	
	/**
	 * generate num random posts
	 */
	public List<Post> randPosts(int total, int num){
		logger.info("Entering randPosts[]");
        List<Post> result = new ArrayList<Post>();
        Random rand = new Random();
        int postid = 0;
        PostService ps = new PostService();
        Post post = null;
        for (int i = 0; i < num; i++) {
        	postid = rand.nextInt(total)+1;
        	post = ps.getPostById(postid);
        	result.add(post);
		}
        
        logger.info("Exiting randPosts");
        return result;
	}
	
	/**
	 * return the total number of users.
	 */
	@SuppressWarnings("unchecked")
	public int totalUsers(){
		logger.info("Entering totalUsers");
		EntityManager em = EMF.get().createEntityManager();
		List<Object> results;
		int count = 0;
		try {
			Query q = em.createNativeQuery("SELECT COUNT(DISTINCT userid) FROM Post");
            results =q.getResultList();
            count = ((Number) results.get(0)).intValue();
        } finally {
            em.close();
        }
        logger.info("Exiting totalUsers");
        return count;
	}

	/**
	 * return the total number of Posts based on category.
	 */
	@SuppressWarnings("unchecked")
	public int totalPostsByCategory(String category){
		logger.info("Entering totalPostsByCategory");
		EntityManager em = EMF.get().createEntityManager();
		List<Object> results;
		int count = 0;
		try {
			Query q = em.createQuery("SELECT COUNT(c.postid) FROM Post c WHERE c.category = :category");
			q.setParameter("category", category);
            results =q.getResultList();
            count = ((Number) results.get(0)).intValue();
        } finally {
            em.close();
        }
        logger.info("Exiting totalPostsByCategory");
        return count;
	}
}
