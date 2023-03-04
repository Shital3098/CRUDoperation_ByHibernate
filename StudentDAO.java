package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentDAO {
    

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("student");
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction  =entityManager.getTransaction();
		
		entityTransaction.begin();
		
		StudentDTO student=new StudentDTO();
		student.setId(2);
		student.setName("shital");
		student.setEmail("shital@gmail.com");
		student.setContact(9673258028l);
		student.setCity("Pune");
		
		entityManager.persist(student);
		entityTransaction.commit();
		
		entityManagerFactory.close();
		entityManager.close();
		
	}
}
