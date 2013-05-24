package com.appspot.easyeatatcmu.model;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import com.appspot.easyeatatcmu.databean.Restaurant;

/**
 * Restaurant DAO
 * @author remonx
 *
 */
public class RestaurantService {
private static Logger logger = Logger.getLogger(RestaurantService.class.getName());
	
	/**
	 * create a Restaurant - with persistencce
	 */
	public void createRestaurant(Restaurant c){
		logger.info("Entering createPost: [" 
                + c.getName() + "]");
		EntityManager em = EMF.get().createEntityManager();
		try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        logger.info("Exiting createRestaurant");
	}
	
	/**
     * Gets a Restaurant given an ID
     * @param id
     * @return Restaurant bean
     */
    public Restaurant getRestaurant(int restid) {
        logger.info("Entering getRestaurant[" + restid + "]");
        Restaurant result = null;
        EntityManager em = EMF.get().createEntityManager();
        try {
            result = em.find(Restaurant.class, restid);
        } finally {
            em.close();
        }
        if (result == null) {
            logger.warning("No Restaurant returned");
        }
        logger.info("Exiting getRestaurant");
        return result;
    }
}
