package com.pradeep.emp.demo.domain.entities.student.valueObjects;



public class Father {

    public String firstName;
    public String middleName;
    public String lastName;
    public long contactNo;
    public String occupation;
    public String education;

    public Father(String firstName, String middleName, String lastName, long contactNo, String occupation, String education) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.occupation = occupation;
        this.education = education;
    }
}
