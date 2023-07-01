package com.pradeep.emp.demo.infrastructure.models.student;

import com.pradeep.emp.demo.commons.Constants;
import com.pradeep.emp.demo.domain.entities.student.valueObjects.Address;
import com.pradeep.emp.demo.domain.entities.student.valueObjects.Father;
import com.pradeep.emp.demo.domain.entities.student.valueObjects.Mother;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Student DAO class is basically for fetching the already registered student's details.
 */
@Getter
@Service
@RequiredArgsConstructor
@Document(collection = Constants.studentCollectionName)
public class StudentDAO {

    @Field("_id")
    String id;

    @Field("name")
    public String name;
    @Field("birthDate")
    public Date birthDate;

    @Field("userName")
    public String userName;
    @Field("email")
    public String email;

    @Field("contactNo")
    public long contactNo;
    @Field("rollNumber")
    public String rollNumber;
    @Field("branch")
    public String branch;
    @Field("course")
    public String[] course;

    @Field("addressDetails")
    public Address address;
    @Field("fatherDetails")
    public Father father;
    @Field("motherDetails")
    public Mother mother;
    @Field("createdOn")
    public Date createdOn;
    @Field("createdBy")
    public String createdBy;

}
