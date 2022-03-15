package com.inn.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.main.model.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Integer> {

//	@Query(value="select name from student where name like='%s'",nativeQuery = true) 
//	public List<String> getallName();
}