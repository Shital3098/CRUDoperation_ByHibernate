package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.codestandard.dto.StudentDTOcodeStandard;
import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDaoInsert {

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
	   
	   StudentDTO studentDTO=new StudentDTO();
	   studentDTO.setId(20);
	   studentDTO.setName("Shreyash");
	   studentDTO.setEmail("shreyu@gmail.com");
	   studentDTO.setContact(65877876l);
	   studentDTO.setCity("PUNE");
	   
	   entityManager.persist(studentDTO);
	   entityTransaction.commit();
	   
	   closeConnection();
	   	   
}

}
