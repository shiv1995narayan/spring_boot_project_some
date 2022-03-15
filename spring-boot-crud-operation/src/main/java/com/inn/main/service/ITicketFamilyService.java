package com.inn.main.service;

import com.inn.main.model.TicketFamily;
import com.inn.util.StudentException;

public interface ITicketFamilyService {

	public TicketFamily createTicketFamily(TicketFamily ticketFamily) throws StudentException;
}
