package com.universityHelper.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.universityHelper.models.CommentNotification;

/**
 * Session Bean implementation class NotificationService
 */
@Stateless
@LocalBean
public class NotificationService implements NotificationServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
    public NotificationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean deleteNotification(String notificationId) {
		
		CommentNotification cm=em.find(CommentNotification.class,notificationId);
		em.remove(cm);
		
		
		
		return false;
	}
    
    

}
