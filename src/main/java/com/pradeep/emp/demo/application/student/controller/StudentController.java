package com.pradeep.emp.demo.application.student.controller;

import com.pradeep.emp.demo.application.exception.InvalidArgumentException;
import com.pradeep.emp.demo.application.exception.StudentNotFoundException;
import com.pradeep.emp.demo.application.student.models.StudentRequestPayload;
import com.pradeep.emp.demo.application.student.models.StudentResponsePayload;
import com.pradeep.emp.demo.application.student.service.AddressService;
import com.pradeep.emp.demo.application.student.service.FatherDetailsService;
import com.pradeep.emp.demo.application.student.service.MotherDetailsService;
import com.pradeep.emp.demo.domain.entities.student.Student;
import com.pradeep.emp.demo.infrastructure.models.student.StudentDAO;
import com.pradeep.emp.demo.infrastructure.studentRepository.StudentDaoRepo;
import com.pradeep.emp.demo.infrastructure.studentRepository.StudentRepository;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * The Student Controller class is for exposing student related functionalities.
 */
@Slf4j
@RestController
@RequestMapping("/student")
@SuppressWarnings("all")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentDaoRepo studentDaoRepo;
    @Autowired
    private AddressService addressService;
    @Autowired
    private FatherDetailsService fatherDetailsService;
    @Autowired
    private MotherDetailsService motherDetailsService;

    /**
     * This below method is basically for creating the student record in the system.
     *
     * @param studentContext The student request body.
     * @param errors         The error handler class (Spring's Validation service)
     *                       basically for handling the request body related errors.
     * @return responsePayload if student record created successfully.
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@Valid @RequestBody StudentRequestPayload studentContext,
                                             @PathParam("createdBy") String createdBy, @PathParam("password") String password,
                                             Errors errors) {

        try {

            if (errors.hasErrors()) {
                log.error("Error in register student event -> " + HttpStatus.BAD_REQUEST + " :: " + new InvalidArgumentException(Objects.requireNonNull(errors.getFieldError()).getDefaultMessage()));
                return new ResponseEntity<>(new InvalidArgumentException(Objects.requireNonNull(errors.getFieldError()).getDefaultMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
            }


            Student student = Student.Factory.createStudent(studentContext.getStudentName(), studentContext.birthDate,
                    studentContext.userName, studentContext.password, studentContext.email, studentContext.contactNo,
                    createdBy, studentContext.branch + "" + Instant.now().getEpochSecond(),
                    studentContext.branch, studentContext.course, addressService.getAddressDetails(studentContext.addressDetails),
                    fatherDetailsService.getFatherDetails(studentContext.fatherDetails),
                    motherDetailsService.getMotherDetails(studentContext.motherDetails));
            try {
                studentRepository.save(student);

                log.info("Student Registered Successfully");

                return new ResponseEntity<>(new StudentResponsePayload(student.userName, student.rollNumber, student.createdOn,
                        student.createdBy), new HttpHeaders(), HttpStatus.CREATED);
            } catch (Exception persistenceExc) {
                log.error("Error while creating entity :: " + HttpStatus.BAD_REQUEST + " -> " + persistenceExc.getLocalizedMessage());
                return ResponseEntity.ok(persistenceExc.getLocalizedMessage());
            }


        } catch (Exception e) {
            log.error("Exception while registering student :: " + HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(e.getLocalizedMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method is basically used to fetch all students.
     *
     * @return all students.
     */
    @GetMapping("/fetchAllStudents")
    public ResponseEntity<?> getAllStudent() {

        try {

            List<StudentDAO> studentsList = studentDaoRepo.findAll();
            HttpHeaders headers = new HttpHeaders();
            if (!studentsList.isEmpty()) {
                //HttpHeaders headers = new HttpHeaders();
                headers.set("total records", String.valueOf(studentsList.size()));
                return new ResponseEntity<>(studentsList, headers, HttpStatus.FOUND);
            } else {
                log.info("No Student found in the pesistence store.");
                headers.set("total records", String.valueOf(studentsList.size()));
                return new ResponseEntity<>(studentsList, headers, HttpStatus.NOT_FOUND);
                // return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            log.error("Exception while fetching all students:: " + HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(StudentNotFoundException.class, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetch/userName")
    public ResponseEntity<?> getSudentByUserName(@RequestParam(value = "userName") String studentUserName) {

        try {
            StudentDAO student = studentDaoRepo.fetchByUserName(studentUserName);

            if (student != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.set("student", "1");
                return new ResponseEntity<>(student, headers, HttpStatus.FOUND);
            } else {
                log.info("No Student found in the pesistence store.");
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(StudentNotFoundException.class, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetch/email")
    public ResponseEntity<?> getStudentByEmail(@RequestParam(value = "email") String emailID) {
        try {

            StudentDAO student = studentDaoRepo.fetchByEmail(emailID);

            if (student != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.set("student", "1");
                return new ResponseEntity<>(student, headers, HttpStatus.FOUND);
            } else {
                log.info("No Student found in the pesistence store.");
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(StudentNotFoundException.class, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetch/mobile")
    public ResponseEntity<?> getStudentByMobile(@RequestParam(value = "mobile", required = true) long mobileNo) {
        try {

            StudentDAO student = studentDaoRepo.fetchByContactNo(mobileNo);

            if (student != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.set("student", "1");
                return new ResponseEntity<>(student, headers, HttpStatus.FOUND);
            } else {
                log.info("No Student found in the pesistence store.");
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(StudentNotFoundException.class, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetch/rollNo")
    public ResponseEntity<?> getStudentByRollNo(@RequestParam(value = "rollNo", required = true) String rollNo) {
        try {

            StudentDAO student = studentDaoRepo.fetchByRollNo(rollNo);

            if (student != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.set("student", "1");
                return new ResponseEntity<>(student, headers, HttpStatus.FOUND);
            } else {
                log.info("No Student found in the pesistence store.");
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(StudentNotFoundException.class, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
