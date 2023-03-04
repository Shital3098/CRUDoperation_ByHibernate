 package com.jspiders.hibernate.codestandard.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.codestandard.dto.StudentDTOcodeStandard;

public class StudentDAOInsert1 {

	
		    private static EntityManagerFactory entityManagerFactory;
	       private static EntityManager entityManager;
	       private static EntityTransaction entityTransaction;
	       
	       public static void openConnection() {
	    	   entityManagerFactory=Persistence.createEntityManagerFactory("student");
	    	   
	    	   entityManager=entityManagerFactory.createEntityManager();
	    	   
	    	   entityTransaction=entityManager.getTransaction();
	    			   
	       }
	       public static void closeConnection() {
	    	   if(entityManagerFactory !=null) {
	    		   entityManagerFactory.close();
	    		   }
	    	   if(entityManager !=null) {
	    		   entityManager.close();
	    	   }
	    	   if(entityTransaction.isActive()) {
	    		   entityTransaction.rollback();
	    	   }
	       }
	       public static void main(String[] args) {
			
	    	   openConnection();
	    	   entityTransaction.begin();
	    	   
	    	   StudentDTOcodeStandard studentDTOcodeStandard=new StudentDTOcodeStandard();
	    	   studentDTOcodeStandard.setId(16);
	    	   studentDTOcodeStandard.setName("Aditya");
	    	   studentDTOcodeStandard.setEmail("ad@gmail.com");
	    	   studentDTOcodeStandard.setContact(6587867876l);
	    	   studentDTOcodeStandard.setCity("PUNE");
	    	   
	    	   entityManager.persist(studentDTOcodeStandard);
	    	   entityTransaction.commit();
	    	   
	    	   closeConnection();
	    	   	   
		}
	

}
