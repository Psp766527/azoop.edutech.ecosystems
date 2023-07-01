package com.pradeep.emp.demo.infrastructure.studentRepository;

import com.pradeep.emp.demo.domain.entities.student.Student;
import com.pradeep.emp.demo.infrastructure.models.student.StudentDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Pradeep Kushwah
 * The StudentServiceRepoIMPL class is basically for custom repository method to manipulate or basic queries from
 * StudentServiceRepo interface.
 */
@Service
@AllArgsConstructor
public class StudentServiceRepoIMPL implements StudentServiceRepo {

    private StudentRepository studentRepository;

    private StudentDaoRepo studentDaoRepo;

    /**
     * <p>
     * This method will be used to register the student in the persistence store if no duplicate record found.
     * Against ( email,contact number,user name).
     * </p>
     *
     * @param studentContext student entity class context.
     * @return student's context if record created successfully in persistence store.
     */
    @Override
    public Student registerStudent(Student studentContext) {

        if (getStudentByEmail(studentContext.email).isPresent()
                || getStudentByContactNo(studentContext.contactNo).isPresent()
                || getStudentByUserName(studentContext.userName).isPresent()) {
            return new Student();
        }
        return studentRepository.save(studentContext);
    }

    /**
     * <p>
     * This method will be used to update the already registered student in the persistence store
     * if record found successfully.
     * </p>
     *
     * @param updatedStudentContext updated student entity class context.
     * @return student's context if record updated successfully in the persistence store.
     */
    @Override
    public Student updateStudent(Student updatedStudentContext) {
        return new Student();
    }

    /**
     * <p>
     * This method will be used to fetch all student's records present in the persistence store if present.
     * </p>
     *
     * @return student's context list if record found in the persistence store.
     */
    @Override
    public List<StudentDAO> getAllStudents() {
        return studentDaoRepo.findAll();
    }

    /**
     * <p>
     * This method will be used to fetch student by identifying student's record using unique roll number in persistence
     * store.
     * </p>
     *
     * @param rollNo student's roll number (unique value)
     * @return student's context if record found successfully in persistence store against roll number.
     */
    @Override
    public Optional<StudentDAO> getStudentByRollNo(String rollNo) {
        Optional<StudentDAO> student = Optional.ofNullable(studentDaoRepo.fetchByRollNo(rollNo));

        if (student.isPresent()) return Optional.empty();

        return student;
    }

    /**
     * <p>
     * This method will be used to fetch student by identifying student's record using unique email in persistence
     * store.
     * </p>
     *
     * @param email student's email (unique value)
     * @return student's context if record found successfully in persistence store against email.
     */
    @Override
    public Optional<StudentDAO> getStudentByEmail(String email) {
        Optional<StudentDAO> student = Optional.ofNullable(studentDaoRepo.fetchByEmail(email));

        if (student.isPresent()) return Optional.empty();

        return student;
    }

    /**
     * <p>
     * This method will be used to fetch student by identifying student's record using unique contact number in
     * persistence store.
     * </p>
     *
     * @param contactNo student's contact number (unique value)
     * @return student's context if record found successfully in persistence store against contact number.
     */
    @Override
    public Optional<StudentDAO> getStudentByContactNo(long contactNo) {

        Optional<StudentDAO> student = Optional.ofNullable(studentDaoRepo.fetchByContactNo(contactNo));

        if (student.isPresent()) return Optional.empty();

        return student;

    }

    /**
     * <p>
     * This method will be used to fetch student by identifying student's record using unique userName in
     * persistence store.
     * </p>
     *
     * @param userName student's user name (unique value)
     * @return student's context if record found successfully in persistence store against userName.
     */
    @Override
    public Optional<StudentDAO> getStudentByUserName(String userName) {
        Optional<StudentDAO> student = Optional.ofNullable(studentDaoRepo.fetchByUserName(userName));

        if (student.isPresent()) return Optional.empty();

        return student;
    }
}
