package com.pradeep.emp.demo.infrastructure.models.student.valueObjects;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Father DAO class is basically for fetching the already registered Father's details.
 */
@AllArgsConstructor
public class Father {
    @Field("firstName")
    public String firstName;
    @Field("middleName")
    public String middleName;
    @Field("lastName")
    public String lastName;

    @Field("contactNo")
    public long contactNo;
    @Field("occupation")
    public String occupation;
    @Field("education")
    public String education;

}
