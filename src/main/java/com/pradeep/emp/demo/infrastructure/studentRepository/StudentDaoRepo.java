package com.pradeep.emp.demo.infrastructure.studentRepository;

import com.pradeep.emp.demo.infrastructure.models.student.StudentDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDaoRepo extends MongoRepository<StudentDAO, String> {
    @Query("{email: ?0}")
    StudentDAO fetchByEmail(String email);
    @Query("{contactNo: ?0}")
    StudentDAO fetchByContactNo(long contactNo);
    @Query("{rollNumber: ?0}")
    StudentDAO fetchByRollNo(String rollNo);
    @Query("{userName: ?0}")
    StudentDAO fetchByUserName(String userName);
}
