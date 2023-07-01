package com.pradeep.emp.demo.domain.entities.teacher;


import com.pradeep.emp.demo.commons.Constants;
import com.pradeep.emp.demo.domain.entities.teacher.valueObject.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

/**
 * This class is responsible for the teacher entry in the persistence store.
 */
@Document(collection = Constants.teacherCollectionName)
public class Teacher {
    public String name;
    @Id
    @Indexed(unique = true)
    public String userName;
    public char[] password;
    public String email;
    @Indexed(unique = true)
    public long contactNo;
    @DBRef
    public Address address;
    public long createdOn;

    /**
     * This parametrized constructor is responsible for the creation of the Teacher in the persistence store.
     * @param name The teacher's name.
     * @param userName The user name.
     * @param password The password.
     * @param email The email id of the user.
     * @param contactNo The teacher's contact no.
     * @param address The teacher's address.
     */
    private Teacher(String name,String userName,char[] password,String email,long contactNo,Address address){
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.contactNo = contactNo;
        this.address = address;
        this.createdOn = Instant.now().getEpochSecond();
    }

    /**
     * This static factory inner will be responsible for creating the Teacher Object by taking inputs from the end user.
     */
    public static class Factory{

        /**
         * This parametrized concrete static method is responsible for the initialization of the Teacher .
         * @param name The teacher's name.
         * @param userName The user name.
         * @param password The password.
         * @param email The email id.
         * @param address The teacher's address.
         *
         * @return it returns teacher's object.
         */
        public static Teacher createTeacher(String name,String userName,char[] password,String email,long contactNo,Address address){

            return new Teacher(name,userName,password,email,contactNo,address);
        }
    }
}
