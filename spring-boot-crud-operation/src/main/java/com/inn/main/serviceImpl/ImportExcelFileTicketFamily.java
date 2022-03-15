package com.inn.main.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.inn.main.model.TicketFamily;
import com.inn.main.service.ITicketFamilyService;
import com.inn.util.StudentException;

@Service
public class ImportExcelFileTicketFamily {
	@Autowired
	private ITicketFamilyService ticketFamilyService;
	
	public List<TicketFamily> importExcelFileTicketFamily(MultipartFile files)throws IOException, StudentException {
        List<TicketFamily> students = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
        // Read student data form excel file sheet1.
        XSSFSheet worksheet = workbook.getSheetAt(0);
        TicketFamily ticketFamily = new TicketFamily();
        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                XSSFRow row = worksheet.getRow(index);
                ticketFamily.name = getCellValue(row, 0);
                ticketFamily.description = getCellValue(row, 1);
               
                students.add(ticketFamily);
            }
        }
        // Save to db.
        List<TicketFamily> entities = new ArrayList<>();
        if (students.size() > 0) {
            students.forEach(x->{
            	TicketFamily entity = new TicketFamily();
                entity.name = x.name;
                entity.description = x.description;
                entities.add(entity);
            });
            ticketFamilyService.createTicketFamily(ticketFamily);
        }
        return students;
    }
    private int convertStringToInt(String str) {
        int result = 0;
        if (str == null || str.isEmpty() || str.trim().isEmpty()) {
            return result;
        }
        result = Integer.parseInt(str);
        return result;
    }
    private String getCellValue(Row row, int cellNo) {
        DataFormatter formatter = new DataFormatter();
        Cell cell = row.getCell(cellNo);
        return formatter.formatCellValue(cell);
    }
}
