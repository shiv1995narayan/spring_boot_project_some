package com.inn.main.dao;

import com.inn.main.model.TicketFamily;


public interface ITicketFamilyDao extends IGenericDao2<Integer, TicketFamily>{

	public TicketFamily ExistTicketFamilycode(String familyCode);

}
