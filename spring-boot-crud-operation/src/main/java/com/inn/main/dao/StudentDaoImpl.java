package com.inn.main.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.LoggerFactory;

import com.inn.main.model.Student;
import com.inn.main.serviceImpl.StudentServiceImpl;

import ch.qos.logback.classic.Logger;

public class StudentDaoImpl implements IStudentDao{

	@PersistenceContext
	EntityManager entityManager;

	Logger logger = (Logger) LoggerFactory.getLogger(StudentDaoImpl.class);
	
	@Override
	public Student studentNameExist(String name) {
		try {
			logger.info("inside method studentNameExist");
			Query query = entityManager.createNamedQuery("getstudentByName").setParameter("name", name);
			return (Student) query.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
