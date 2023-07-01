package com.pradeep.emp.demo.domain.entities.student;

import com.pradeep.emp.demo.commons.Constants;
import com.pradeep.emp.demo.domain.entities.student.valueObjects.Address;
import com.pradeep.emp.demo.domain.entities.student.valueObjects.Father;
import com.pradeep.emp.demo.domain.entities.student.valueObjects.Mother;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.Date;

/**
 * This class is responsible for the student entry in the persistence store.
 */
@NoArgsConstructor
@Document(collection = Constants.studentCollectionName)
public class Student {

    @Id
    String id;
    public String name;
    public Date birthDate;
    @Indexed(name = "userName", unique = true)
    public String userName;
    public String password;
    @Indexed(name = "email", unique = true)
    public String email;
    @Indexed(name = "contactNo", unique = true)
    public long contactNo;
    @Indexed(name = "rollNumber", unique = true)
    public String rollNumber;
    public String branch;
    public String[] course;

    @Field("addressDetails")
    public Address address;
    @Field("fatherDetails")
    public Father father;
    @Field("motherDetails")
    public Mother mother;
    @CreatedDate
    public Date createdOn;
    @CreatedBy
    public String createdBy;

    /**
     * @param name       The student's name.
     * @param birthDate  The student's birthDate.
     * @param userName   The student's userName.
     * @param password   The student's password.
     * @param email      The student's email id.
     * @param contactNo  The student's contactNo.
     * @param createdBy  The record created by.
     * @param rollNumber The student's roll number by which he will be identified.
     * @param branch     The branch in which student is studying.
     * @param course     The course in which student is enrolled.
     * @param address    The address of student (communication & permanent).
     * @param father     The father details of the student.
     * @param mother     The mother details of the student.
     */
    private Student(String name, Date birthDate, String userName, String password, String email, long contactNo,
                    String createdBy, String rollNumber, String branch, String[] course, Address address,
                    Father father, Mother mother) {
        this.id = rollNumber;
        this.name = name;
        this.birthDate = birthDate;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.contactNo = contactNo;
        this.rollNumber = rollNumber;
        this.branch = branch;
        this.course = course;
        this.address = address;
        this.father = father;
        this.mother = mother;
        this.createdOn = Date.from(Instant.now());
        this.createdBy = createdBy;
    }

    /**
     * This static factory inner will be responsible for creating the Student Object by taking inputs from the end user.
     */
    public static class Factory {

        /**
         * This parametrized concrete static method is responsible for the initialization of the Student .
         *
         * @param name       The student's name.
         * @param rollNumber The student's roll number by which he will be identified.
         * @param branch     The branch in which customer is studying.
         * @param course     The courses which student opt to study.
         * @param address    The address details of the student either permanent or communication & permanent both.
         * @param father     The student's father details.
         * @param mother     The student's mother details.
         * @return it returns Student's object.
         */
        public static Student createStudent(String name, Date birthDate, String userName, String password, String email,
                                            long contactNo, String rollNumber, String createdBy, String branch,
                                            String[] course, Address address, Father father, Mother mother) {

            return new Student(name, birthDate, userName, password, email, contactNo, rollNumber, createdBy, branch, course,
                    address, father, mother);
        }
    }
}
