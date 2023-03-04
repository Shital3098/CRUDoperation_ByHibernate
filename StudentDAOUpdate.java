package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAOUpdate {
    public static void main(String[] args) {
	    EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("student");
	    
	    EntityManager entityManager =entityManagerFactory.createEntityManager();
	    
	    EntityTransaction entityTransaction=entityManager.getTransaction();
	    
	    entityTransaction.begin();
	    
	    StudentDTO studentDTO=entityManager.find(StudentDTO.class, 1);
	    studentDTO.setEmail("ps@gmail.com");
	    
	    entityManager.persist(studentDTO);
	    entityTransaction.commit();
	    entityManagerFactory.close();
	    entityManager.close();
	    
	    
	}
}
