package com.pradeep.emp.demo.infrastructure.studentRepository;

import com.pradeep.emp.demo.domain.entities.student.Student;
import com.pradeep.emp.demo.infrastructure.models.student.StudentDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Pradeep Kushwah
 * The StudentServiceRepo interface is basically used to define abstract methods which will be later implimented in the
 * derived class. And will help out to persist data in persistence store.
 */
@Repository
public interface StudentServiceRepo {
    Student registerStudent(Student studentContext);

    List<StudentDAO> getAllStudents();

    Optional<StudentDAO> getStudentByRollNo(String rollNo);

    Optional<StudentDAO> getStudentByEmail(String id);

    Optional<StudentDAO> getStudentByContactNo(long contactNo);

    Optional<StudentDAO> getStudentByUserName(String userName);

    Student updateStudent(Student updatedStudentContext);

}
