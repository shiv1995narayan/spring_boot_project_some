package com.inn.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inn.main.model.Student;
import com.inn.main.service.IStudentService;
import com.inn.util.StudentException;

@RestController
@RequestMapping("/api")
public class StudentController {
  
	@Autowired
	private IStudentService studentService;
	
	@PostMapping(path = "/create",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Student createData(@RequestBody Student student)throws StudentException {
			return studentService.createStudent(student);
	}
	
	@GetMapping(path="/getAllRecord")
	public List<Student> getAllRecord() throws StudentException{
		return studentService.getAllRecord();
	}
	
	@GetMapping(path="/getStudentById/{id}")
	public Student getStudentById(@PathVariable int id) throws StudentException{
		return studentService.getStudentById(id);
	}
	
	@PostMapping(path = "/update")
	public Student updateData(@RequestBody Student student)throws StudentException {
		return studentService.updateDataStudent(student);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public String deleteData(@PathVariable int id) throws StudentException{
		return studentService.deleteData(id);
	}
	
//	@DeleteMapping(path="/delete/{id}")
//	public String deleteDatas(@RequestParam ("id") int id) throws StudentException{
//		return studentService.deleteData(id);
//	}
//	
//	@RequestMapping(path="/delete/{id}",method=RequestMethod.DELETE)
//	public String deleteDatas_re(@PathVariable int id) throws StudentException{
//		return studentService.deleteData(id);
//	}
	
}
