package com.appspot.easyeatatcmu.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.appspot.easyeatatcmu.databean.Tag;

/**
 * Tag DAO
 * @author remonx
 *
 */
public class TagService {
	private static Logger logger = Logger.getLogger(TagService.class.getName());
	
	/**
	 * create a tag - with persistencce
	 * return the tagid of the newly created tag.
	 * or the tagid, if the tag is already existed.
	 */
	@SuppressWarnings("unchecked")
	public int createTag(String c){
		logger.info("Entering createTag: [" 
                + c + "]");
		EntityManager em = EMF.get().createEntityManager();
			Tag tag = new Tag();
			int result = 0;
		try {
			//calculate new tag id based on row numbers
			Query query = em.createNativeQuery("SELECT TABLE_ROWS FROM information_schema.tables " +
					"WHERE TABLE_SCHEMA = 'easyeat' "+
					"AND TABLE_NAME = 'Tag'");
			List<Number> counts = (List<Number>) query.getResultList();
			int id = counts.get(0).intValue()+1;
			System.out.println(id);
			tag.setTagid(id);
			tag.setTagname(c);
            em.getTransaction().begin();
            em.persist(tag);
            //em.flush();
            em.getTransaction().commit();
            result = tag.getTagid();
        }catch(Exception e){
        	//use exception to deal with duplicated tag
        	logger.info("Exception when create tag, could be duplicated value");
        	//get the tagid of the duplicated one
        	Query query2 = em.createNativeQuery("SELECT tagid FROM Tag WHERE tagname = '"+c+"'");
        	List<Number> dupid = (List<Number>) query2.getResultList();
			result = dupid.get(0).intValue();
			System.out.println(dupid);
        }
        em.close();
        logger.info("Exiting createTag");
        //System.out.println(tag.getTagid());
        return result;
	}
	
	/**
	 * list all tags
	 */
	@SuppressWarnings("unchecked")
	public List<Tag> listTags(){
		logger.info("Entering listTag");
		EntityManager em = EMF.get().createEntityManager();
		List<Tag> result;
		try {
			Query query = em.createNamedQuery("Tag.findAll");
            result =(List<Tag>)query.getResultList();
        } finally {
            em.close();
        }
        logger.info("Exiting createTag");
        return result;
	}
	
	/**
	 * insert tag array
	 */
	public int[] insertTagArray(String[] tagArray){
		logger.info("Entering insertTagArray");
		int[] array = new int[tagArray.length];
		EntityManager em = EMF.get().createEntityManager();
		for(int i=0;i<tagArray.length;i++){
			try {
				array[i] = createTag(tagArray[i]);
	        }catch(Exception e){
	        	logger.info("Exception when insert tag, could be duplicated value");
	        }
		}
		
        em.close();
        logger.info("Exiting insertTagArray");
        return array;
	}
	
	/**
	 * given prefix, find all matched Tag.
	 */
	@SuppressWarnings("unchecked")
	public List<Tag> prefixTags(String prefix){
		logger.info("Entering prefixTags");
		EntityManager em = EMF.get().createEntityManager();
		List<Tag> result;
		try {
			Query q = em.createQuery("SELECT c FROM Tag c WHERE c.tagname like 'c%'");
        	//q.setParameter("prefix", prefix+"%");
            result =(List<Tag>)q.getResultList();
        } finally {
            em.close();
        }
        logger.info("Exiting prefixTags");
        return result;
		
//		EntityManager em = EMF.get().createEntityManager();
//		List<Tag> result;
//		List<Tag> list = new ArrayList<Tag>();
//		try {
//			//Query q = em.createNativeQuery("SELECT * FROM Tag WHERE tagid = 1");
//			result = (List<Tag>)em.createNativeQuery
//                    
//
//		            ("SELECT * FROM Tag WHERE tagid =1", com.appspot.easyeatatcmu.databean.Tag.class)
//		                              .getResultList(); 
//        	//q.setParameter("prefix", prefix+"%");
//            //result =(List<Tag>)q.getResultList();
//            Iterator i = result.iterator();
//            Tag tag;
//            while (i.hasNext()) {
//                tag = (Tag) i.next();
//                list.add(tag);
//            }
//        } finally {
//            em.close();
//        }
//        
//        return result;
	}
	
	/**
	 * given tagid, return tag
	 */
	public Tag getTagById(int tagid){
		logger.info("Entering getNameById");
		EntityManager em = EMF.get().createEntityManager();
		Tag tag = null;
		try{
			tag = em.find(Tag.class, tagid);
		}finally {
            em.close();
        }
        logger.info("Exiting getNameById");
        return tag;
	}

}
