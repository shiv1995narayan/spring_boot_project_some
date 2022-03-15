package com.inn.main.dao;

import com.inn.main.model.Student;

public interface IStudentDao extends IGenericDao<Integer, Student>{

	Student studentNameExist(String name);

}
