package com.inn.main.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.inn.main.model.Student;
import com.inn.main.model.TicketFamily;

@Repository
public class TicketFamilyDaoImpl  implements ITicketFamilyDao{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public TicketFamily ExistTicketFamilycode(String familyCode) {
		try {
			System.out.println("inside method ExistTicketFamilycode");
			Query query = entityManager.createNamedQuery("ExistTicketFamilycode").setParameter("familyCode", familyCode);
			return (TicketFamily) query.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
