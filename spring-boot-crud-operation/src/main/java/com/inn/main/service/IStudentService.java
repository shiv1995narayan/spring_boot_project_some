package com.inn.main.service;

import java.util.List;

import com.inn.main.model.Student;
import com.inn.util.StudentException;

public interface IStudentService {

	public Student createStudent(Student student) throws StudentException;

	public List<Student> getAllRecord() throws StudentException;

	public Student updateDataStudent(Student student) throws StudentException;

	public String deleteData(int id) throws StudentException;

	public Student getStudentById(int id) throws StudentException;



}
