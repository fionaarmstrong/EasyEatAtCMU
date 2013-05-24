package com.appspot.easyeatatcmu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.appspot.easyeatatcmu.databean.Post;
import com.appspot.easyeatatcmu.databean.Vote;

/**
 * Vote DAO
 * @author remonx
 *
 */
public class VoteService {
	private static Logger logger = Logger.getLogger(VoteService.class.getName());
	
	/**
	 * create a Vote - with persistencce
	 */
	public void createVote(Vote c){
		logger.info("Entering createVote: [" 
                + c.getVoteid() + "]");
		EntityManager em = EMF.get().createEntityManager();
		try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        logger.info("Exiting createVote");
	}
	
	/**
	 * Check whether an user has vote for a given post - with persistencce
	 */
	public Vote voteLookup(int userid, int postid, String updown){
		logger.info("Entering voteLookup: [" 
                + userid +"  "+postid+"]");
		EntityManager em = EMF.get().createEntityManager();
		Vote result = null;
		try {
			Query q = em.createQuery("SELECT c FROM Vote c WHERE c.userid = :userid AND " +
					"c.post.postid = :postid AND c.updown = :updown");
        	q.setParameter("userid", userid);
        	q.setParameter("postid", postid);
        	q.setParameter("updown", updown);
        	//System.out.println("fetching lookup result");
        	@SuppressWarnings("unchecked")
			List<Vote> list = (List<Vote>)q.getResultList();
        	if(list.size() != 0)
        		result = list.get(0);
        } finally {
            em.close();
        }
        logger.info("Exiting voteBefore");
        return result;
	}
	
	/**
	 * Delete a Vote
	 */
	public void deleteVote(int userid, int postid, String updown){
		logger.info("Entering deleteVote: [" 
                + userid +"  "+postid+"]");
		EntityManager em = EMF.get().createEntityManager();
		int deletedCount;
		try {
			Query query = em.createQuery(
				      "DELETE FROM Vote c WHERE c.post.postid = :postid AND c.userid = :userid" +
				      " AND c.updown = :updown");
			query.setParameter("postid", postid);
			query.setParameter("userid", userid);
			query.setParameter("updown", updown);
			em.getTransaction().begin();
			deletedCount = query.executeUpdate();
			em.getTransaction().commit();
        } finally {
            em.close();
        }
        logger.info("Exiting deleteVote. delete "+deletedCount);
	}
	
	/**
	 * Get the number of Votes of a post for one user.
	 * Up and Down provided different argument.
	 */
	@SuppressWarnings("unchecked")
	public int getNumVoteByUser(int postid, int userid, String updown){
		logger.info("Entering getNumVoteByUser: [" 
                + userid +"  "+postid+"]");
		EntityManager em = EMF.get().createEntityManager();
		List<Vote> list;
		int num = 0;
		try {
			Query query = em.createQuery(
				      "SELECT c FROM Vote c WHERE c.post.postid = :postid AND c.userid = :userid" +
				      " AND c.updown = :updown");
			query.setParameter("postid", postid);
			query.setParameter("userid", userid);
			query.setParameter("updown", updown);
			list = (List<Vote>)query.getResultList();
        } finally {
            em.close();
        }
		if(list.size() != 0){
			num = list.size();
		}
        logger.info("Exiting getNumVoteByUser. number is "+ num);
        return num;
	}
	
	/**
	 * Get the number of Votes of a post.
	 * Up and Down provided different argument.
	 */
	@SuppressWarnings("unchecked")
	public int getNumVote(int postid, String updown){
		logger.info("Entering getNumVote: [" 
                +"  "+postid+"]");
		EntityManager em = EMF.get().createEntityManager();
		List<Vote> list;
		int num = 0;
		try {
			Query query = em.createQuery(
				      "SELECT c FROM Vote c WHERE c.post.postid = :postid" +
				      " AND c.updown = :updown");
			query.setParameter("postid", postid);
			query.setParameter("updown", updown);
			list = (List<Vote>)query.getResultList();
        } finally {
            em.close();
        }
		if(list.size() != 0){
			num = list.size();
		}
        logger.info("Exiting getNumVote. number is "+ num);
        return num;
	}
	
	/**
	 * given an index, list first 6 controversial posts.
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Post> getControPosts(int index, int num, String category){
		logger.info("Entering getControPosts[" + index + "]");
        List<Object[]> results = null;
        PostService ps = new PostService();
        List<Post> list = new ArrayList<Post>();
        EntityManager em = EMF.get().createEntityManager();
        try {
        	index = index * num;
        	Query q = em.createNativeQuery("Select t1.postid, countnum, popularity,countnum-abs(popularity) as con From (select postid, count(*) AS countnum from Vote group by postid) AS t1 join Post on t1.postid = Post.postid order by con desc");
            results = q.setFirstResult(index).setMaxResults(num).getResultList();
            for (int i=0;i<results.size();i++) {
                int postid = ((Number) results.get(i)[0]).intValue();
                System.out.println(postid);
                Post post = ps.getPostById(postid);
                if(post.getCategory().equals(category)){
                	list.add(post);
                }
            }
        } finally {
            em.close();
        }
        if (list.size()==0) {
            logger.warning("No Posts returned");
        }
        logger.info("Exiting getControPosts");
        System.out.println("contro is "+list.size());
        return list;
	}
}
