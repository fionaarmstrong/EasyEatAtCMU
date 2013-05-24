package com.appspot.easyeatatcmu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.appspot.easyeatatcmu.databean.*;

/**
 * DAO for PostTag bean
 * @author Yin Xu
 *
 */
public class PostTagService {
	private static Logger logger = Logger.getLogger(PostService.class.getName());
	
	/**
	 * create a PostTag match - with persistencce
	 */
	public void createPostTag(int postid, int tagid){
		logger.info("Entering createPost: [" 
                +"]");
		EntityManager em = EMF.get().createEntityManager();
		try {
			PostTag pt = new PostTag();
			pt.setPostid(postid);
			pt.setTagid(tagid);
            em.getTransaction().begin();
            em.persist(pt);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        logger.info("Exiting createPost");
	}
	
	/**
	 * given a tagid, select all PostTag bean that contains the tag.
	 */
	@SuppressWarnings("unchecked")
	public List<PostTag> listPTByTagId(int tagid){
		logger.info("Entering listPostsByTagId");
		EntityManager em = EMF.get().createEntityManager();
		List<PostTag> result = null;
		try {
			Query query = em.createQuery("SELECT c FROM PostTag c WHERE c.tagid = :id");
			query.setParameter("id", tagid);
            result =(List<PostTag>)query.getResultList();
        } finally {
            em.close();
        }
        logger.info("Exiting listPostsByTagId");
        return result;
	}
	
//	/**
//	 * get each tag's total appearance
//	 */
//	@SuppressWarnings("unchecked")
//	public String[][] tagStat(){
//		logger.info("Entering tagStat");
//		EntityManager em = EMF.get().createEntityManager();
//		String[][] tagStat = null;
//		List<Object[]> results;
//		TagService ts = new TagService();
//		try {
//			Query q = em.createQuery("SELECT c.tagid, COUNT(c) FROM PostTag c GROUP BY c.tagid ORDER BY COUNT(c) desc");
//            results =q.getResultList();
//            tagStat = new String[results.size()][4];
//            for (int i=0;i<results.size();i++) {
//                int tagid = ((Number) results.get(i)[0]).intValue();
//                tagStat[i][0] = ts.getTagById(tagid).getTagname();
//                //System.out.println(((Number)results.get(i)[1]).intValue());
//                tagStat[i][1] = ""+((Number)results.get(i)[1]).intValue();
//                tagStat[i][2] = ts.getTagById(tagid).getTagdesc();
//                tagStat[i][3] = ""+tagid;
//            }
//        } finally {
//            em.close();
//        }
//        logger.info("Exiting tagStat");
//        return tagStat;
//	}
	
	/**
	 * get n most popular tags
	 */
	/**
	 * get each tag's total appearance
	 */
	@SuppressWarnings("unchecked")
	public List<Tag> getPopularTags(int num){
		logger.info("Entering getPopularTags");
		EntityManager em = EMF.get().createEntityManager();
		List<Tag> list= new ArrayList<Tag>();
		List<Object[]> results;
		TagService ts = new TagService();
		Tag tag = null;
		try {
			Query q = em.createQuery("SELECT c.tagid, COUNT(c) FROM PostTag c GROUP BY c.tagid ORDER BY COUNT(c) desc");
            results =q.getResultList();
            //tagStat = new String[results.size()][4];
            for (int i=0;i<results.size();i++) {
            	if(i < num){
	                int tagid = ((Number) results.get(i)[0]).intValue();
	                tag = ts.getTagById(tagid);
	                list.add(tag);
            	}
            	else
            		break;
            }
        } finally {
            em.close();
        }
        logger.info("Exiting getPopularTags");
        return list;
	}

}
