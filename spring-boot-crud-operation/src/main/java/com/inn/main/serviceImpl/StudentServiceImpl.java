package com.inn.main.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.inn.main.dao.ITicketFamilyDao;
import com.inn.main.model.Student;
import com.inn.main.model.TicketFamily;
import com.inn.main.repository.StudentRepository;
import com.inn.main.service.IStudentService;
import com.inn.util.StudentException;


@Service
public class StudentServiceImpl implements IStudentService{
	Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	public static final String SPECIAL_CHARACTER_STRING = "[+=&,?{}~`'<>$%\\^;\"!#*@]";
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ITicketFamilyDao ticketFamilyDao;
	
	@Override
	public Student createStudent(Student student) throws StudentException{
		Student studentPersist=new Student();
		try{
			logger.info("inside method createStudent",student);
			isFieldNameEmptyOrNot(student);
			Student studentexist=new Student();
		    List<Student> studentList=studentRepository.findAll();
		    List<String> checkList=new ArrayList<>();
		    for(Student list:studentList) {
		    	checkList.add(list.getName());
		    }
		    logger.info("student===={}"+student);
		    String code=student.getTicketfamily().getFamilyCode();
		    TicketFamily tf=ticketFamilyDao.ExistTicketFamilycode(code);
		    logger.info("tf==={}"+tf);
		    if(tf==null) {
		    	throw new StudentException("Ticket Family does not exist");
		    }
			if(!checkList.contains(student.getName()) &&!checkList.contains(student.getMobileNo())) {
				studentexist.setDateOfBirth(student.getDateOfBirth());
				studentexist.setEmail(student.getEmail());
				studentexist.setMobileNo(student.getMobileNo());
				studentexist.setName(student.getName());
				studentexist.setTicketfamily(student.getTicketfamily());
				studentPersist= studentRepository.save(studentexist);
			}
			else {
				throw new StudentException("Student already exist with given name :"+student.getName()+" and mobile no. :"+student.getMobileNo());
			}
			return studentPersist;
		}
		catch(StudentException e) {
			throw e;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			throw new StudentException("SOMETHING WENT WRONG");
		}
	}

	private void isFieldNameEmptyOrNot(Student student) throws StudentException {
		if(StringUtils.isEmpty(student.getName())) {
			throw new StudentException("STUDENT_NAME_CAN'T_BE_EMPTY");
		}
		if (Boolean.TRUE.equals(isContainsSpecialCharacters(student.getName()))) {
			throw new StudentException("STUDENT_NAME_NOT_ALLOW_SPECIAL_CHARACTER");
		}
		if(StringUtils.isEmpty(student.getMobileNo())) {
			throw new StudentException("STUDENT_MOBILE_NO_CAN'T_BE_EMPTY");
		}
		if((student.getMobileNo().toString().length()>10)) {
			throw new StudentException("MOBILE_NO_ALLOW_ONLY_10_DIGIT");	
		}
		else if(!isValidMobileNo(student.getMobileNo().toString())) {
			throw new StudentException("First digit should be start 9/8/7 and number should be numeric");	
		}
		if(StringUtils.isEmpty(student.getEmail())) {
			throw new StudentException("STUDENT_EMAIL_CAN'T_BE_EMPTY");	
		}
		else if(!isValidEmailId(student.getEmail())) {
			throw new StudentException("EMAILID SHOULD HAVE @ AND . AND ONLY ALLOW _");
		}
		if(StringUtils.isEmpty(student.getDateOfBirth())) {
			throw new StudentException("STUDENT DATE OF BIRTH CAN'T BE EMPTY");
		}
		else if(!isDateValid(student.getDateOfBirth())) {
			throw new StudentException("DATE OF BIRTH SHOULD BE DD-MM-YYYY FORMATE");
		}
	}

	@Override
	public List<Student> getAllRecord() throws StudentException {
		try {
			return studentRepository.findAll();	
		}
		catch(Exception ex) {
			throw new StudentException("SOMETHING WENT WRONG");
		}
	}

	@Override
	public Student updateDataStudent(Student student) throws StudentException {
			try {
				isFieldNameEmptyOrNot(student);
				return studentRepository.save(student);
			}
			catch(StudentException ex) {
				throw ex;
			}
			catch(Exception ex) {
				throw new StudentException("SOMETHING WENT WRONG");
			}
		}

	@Override
	public String deleteData(int id) throws StudentException {
		try {
			studentRepository.deleteById(id);
			return "STUDENT DATA DELETED SUCCSESSFULY";
		}
		catch(Exception ex) {
			throw new StudentException("SOMETHING WENT WRONG");
		}
	}
	

	@Override
	public Student getStudentById(int id)throws StudentException {
		try {
		return studentRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new StudentException("STUDENT DATA NOT FOUND");	
		}
	}
	public static Boolean isContainsSpecialCharacters(String s) {
		try {
			Pattern p = Pattern.compile(SPECIAL_CHARACTER_STRING);
			Matcher m = p.matcher(s);
			return m.find();
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isValidMobileNo(String str)  
	{  
	Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
	Matcher match = ptrn.matcher(str);  
	return (match.find() && match.group().equals(str));  
	}
	

		public static boolean isValidEmailId(String emailStr) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		        return matcher.find();
		}
		
		public static boolean isDateValid(String dob){
		    try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		      Date date = formatter.parse(dob);
		      System.out.println("Date object value: "+date);
		   //   String strDate = formatter.format(date);
		      return true;
		    }
		    catch(ParseException e) {
		    	return false;
		    }
		   }

}
