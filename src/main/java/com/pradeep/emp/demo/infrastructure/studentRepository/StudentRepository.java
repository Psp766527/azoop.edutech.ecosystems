package com.pradeep.emp.demo.infrastructure.studentRepository;

import com.pradeep.emp.demo.domain.entities.student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

}
