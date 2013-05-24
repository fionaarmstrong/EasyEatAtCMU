package com.appspot.easyeatatcmu.model;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.appspot.easyeatatcmu.databean.Comment;

/**
 * DAO for Comment bean
 * @author remonx
 *
 */
public class CommentService {
	private static Logger logger = Logger.getLogger(CommentService.class.getName());
	
	/**
	 * create a comment - with persistencce
	 */
	public void createComment(Comment c){
		logger.info("Entering createComment: [" 
                + c.getUser() + "]");
		EntityManager em = EMF.get().createEntityManager();
		try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        logger.info("Exiting createComment");
	}
	
	/**
     * Gets a Comment given an ID
     * @param id
     * @return Comment bean List
     */
   
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentByUser(int userid) {
        logger.info("Entering getComment[" + userid + "]");
        List<Comment> result = null;
        EntityManager em = EMF.get().createEntityManager();
        try {
        	Query q = em.createQuery("SELECT c FROM Comment c WHERE c.user.userid = :userid order by c.createtime desc");
        	q.setParameter("userid", userid);
            result = (List<Comment>)q.getResultList();
        } finally {
            em.close();
        }
        if (result.size()==0) {
            logger.warning("No comments returned");
        }
        logger.info("Exiting getComment");
        return result;
    }
	
	/**
	 * Given a postid and an index, return the list of comments.
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentById(int postid, int page){
		logger.info("Entering getNumComment[" + postid + "]");
        List<Comment> result = null;
        EntityManager em = EMF.get().createEntityManager();
        try {
        	Query q = em.createQuery("SELECT c FROM Comment c WHERE c.post.postid = :postid order by c.createtime desc");
        	q.setParameter("postid", postid);
            result = (List<Comment>)q.setFirstResult(15*page).setMaxResults(15).getResultList();
        } finally {
            em.close();
        }
        logger.info("Exiting getComment");
        return result;
	}
}
