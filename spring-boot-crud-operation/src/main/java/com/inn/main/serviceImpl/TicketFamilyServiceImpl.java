package com.inn.main.serviceImpl;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.inn.main.model.TicketFamily;
import com.inn.main.repository.TicketFamilyRepository;
import com.inn.main.service.ITicketFamilyService;
import com.inn.util.StudentException;

@Service
public class TicketFamilyServiceImpl implements ITicketFamilyService{

	Logger logger = LoggerFactory.getLogger(TicketFamilyServiceImpl.class);
	
	@Autowired
	private TicketFamilyRepository ticketFamilytRepository;
	@Override
	public TicketFamily createTicketFamily(TicketFamily ticketFamily) throws StudentException {
		TicketFamily ticketFamilyPersist=new TicketFamily();
		try{
			logger.info("inside method createTicketFamily");
			isFieldNameEmptyOrNot(ticketFamily);
		    List<TicketFamily> familyList=ticketFamilytRepository.findAll();
		    List<String> checkList=new ArrayList<>();
		    for(TicketFamily list:familyList) {
		    	checkList.add(list.getName());
		    }
			if(!checkList.contains(ticketFamily.getName())) {
				ticketFamily.setActive("Active");
				ticketFamily.setCreationtime(new Date());
				ticketFamily.setDeleted(false);
				ticketFamily.setCreatorUserName("shiv.mewada@rakuten.com");
				ticketFamily.setFamilyCode(generateCustomNumberForTicketFamily());
				ticketFamily.setModificationtime(new Date());
				ticketFamily.setSource("Nexus");
				ticketFamily.setLastModifierUserName("shiv.mewada@rakuten.com");
				ticketFamily.setIntegrationType("new user");
				ticketFamily.setTicketFamilySearch(ticketFamily.getName());
				ticketFamilyPersist= ticketFamilytRepository.save(ticketFamily);
			}
			else {
				throw new StudentException("TicketFamily already exist with given name=={} :"+ticketFamily.getName());
			}
			return ticketFamilyPersist;
		}
		catch(StudentException e) {
			throw e;
		}
		catch(Exception ex) {
			throw new StudentException("SOMETHING WENT WRONG");
		}
	}
	private void isFieldNameEmptyOrNot(TicketFamily ticketFamily) throws StudentException {
		if(StringUtils.isEmpty(ticketFamily.getName())) {
			throw new StudentException("Ticket family name can't be empty");
		}
		
	}
	private String generateCustomNumberForTicketFamily() {
		SecureRandom r = new SecureRandom();
		return "TF-" + ((1 + r.nextInt(2)) * 1000 + r.nextInt(1000));
	}

}
