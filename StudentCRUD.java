package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentCRUD {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
  public static void openConnection() {
	  EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("student");
	  EntityManager entityManager=entityManagerFactory.createEntityManager();
	  EntityTransaction entityTransaction=entityManager.getTransaction();
	  entityTransaction.begin();
  }
  public static void closeConnection() {
	  
	  if(entityManagerFactory !=null) {
		  entityManagerFactory.close(); 
	  }
	  if(entityManager != null) {
		  entityManager.close();
	  }
	  if(entityTransaction != null) {
		  entityTransaction.rollback();
	  }
  }
   public static void insert() {
	      
	      StudentDTO studentDTO=new StudentDTO();
	      studentDTO.setId(19);
	      studentDTO.setName("naresh patil 123");
	      studentDTO.setEmail("naresh@gmail.com");
	      studentDTO.setContact(930345676l);
	      studentDTO.setCity("pune");
	      entityManager.persist(studentDTO);
	      
	      
		   StudentDTO studentDTO1=new StudentDTO();
		   studentDTO1.setId(78);
		   studentDTO1.setName("Shreyash iyer");
		   studentDTO1.setEmail("shreyu@gmail.com");
		   studentDTO1.setContact(9165877876l);
		   studentDTO1.setCity("PUNE");
		   
	      entityManager.persist(studentDTO1);
	      entityTransaction.commit();
	      
   }
   public static void select() {
	   StudentDTO studentDTO =entityManager.find(StudentDTO.class, 25);
	   System.out.println(studentDTO);
	   entityTransaction.commit();
   }
   public static void update() {
	  
	   StudentDTO studentDTO =entityManager.find(StudentDTO.class, 2);
	   entityManager.merge("ps@gmail.com");
	   System.out.println(studentDTO);
	   entityTransaction.commit();

	   
   }
   public static void delete() {
	   
	   StudentDTO studentDTO=entityManager.find(StudentDTO.class, 1);
	   entityManager.remove(studentDTO);
		entityTransaction.commit();

		entityManagerFactory.close();
		entityManager.close();
	     
   }
   public static void main(String[] args) {
	   openConnection();
	   insert();
//	   select();
//	   update();
//	   delete();
		closeConnection();   
	}

}
