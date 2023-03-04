package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.StudentDTO;

public class StudentCrudDAO {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("student");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		
//		inserting the data
		StudentDTO studentDTO= new StudentDTO();
		studentDTO.setId(43);
		studentDTO.setName("naresh");
		studentDTO.setEmail("vb@gmail.com");
		studentDTO.setContact(68678909l);
		studentDTO.setCity("pune");
		entityManager.persist(studentDTO);
		entityTransaction.commit();
	
//		selecting the data
		StudentDTO studentDTO2=entityManager.find(StudentDTO.class, 43 );
		System.out.println(studentDTO2);
		
//		updating the data
		StudentDTO studentDTO3=entityManager.find(StudentDTO.class, 43 );
		studentDTO3.setName("naresh patil");
		entityManager.persist(studentDTO3);
		entityTransaction.commit();
//		deleting the data
		StudentDTO studentDTO4=entityManager.find(StudentDTO.class, 4 );
		entityManager.remove(studentDTO4);
		entityTransaction.commit();
		
		entityManagerFactory.close();
		entityManager.close();
		entityTransaction.rollback();
		
	} 

}
