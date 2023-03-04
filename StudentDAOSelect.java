package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAOSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("student");
        
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        
        EntityTransaction entityTransaction=entityManager.getTransaction();
        
         entityTransaction.begin();
         
         StudentDTO studentDAOSelect= entityManager.find(StudentDTO.class, 1);
         
         System.out.println(studentDAOSelect);
         
         entityTransaction.commit();
         entityManagerFactory.close();
         entityManager.close();
         
	}

}
