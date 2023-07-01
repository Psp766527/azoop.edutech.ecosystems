package com.pradeep.emp.demo.domain.entities.student.valueObjects;

public class Mother {
    public String firstName;
    public String middleName;
    public String lastName;
    public long contactNo;
    public String midName;
    public String occupation;
    public String education;

    public Mother(String firstName, String middleName, String lastName, long contactNo, String midName,
                  String occupation, String education) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.midName = midName;
        this.occupation = occupation;
        this.education = education;
    }
}
