package com.inn.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inn.main.model.TicketFamily;
import com.inn.main.service.ITicketFamilyService;
import com.inn.main.serviceImpl.ImportExcelFileTicketFamily;
import com.inn.util.StudentException;

@RestController
public class TicketFamilyController {

	@Autowired
	private ITicketFamilyService ticketFamilyService;
	
	@Autowired
	private ImportExcelFileTicketFamily importTicketFamily;
	
	@PostMapping(path = "/createTicketFamily")
	public TicketFamily createData(@RequestBody TicketFamily ticketFamily)throws StudentException {
			return ticketFamilyService.createTicketFamily(ticketFamily);
	}
	@PostMapping("/import-order-excel")
    public List<TicketFamily> importExcelFileTicketFamily(@RequestParam("file") MultipartFile files)throws IOException, StudentException {
		{
			return importTicketFamily.importExcelFileTicketFamily(files);
		}
	}
}
