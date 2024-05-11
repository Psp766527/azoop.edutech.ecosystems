package com.pradeep.emp.demo.application.student.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pradeep.emp.demo.commons.Constants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

/**
 * The StudentRequestPayload class is basically for the Student's request body logic.
 */
@Builder
@Data
public class StudentRequestPayload {

    @NotNull(message = "firstName can not be null.")
    @NotEmpty(message = "firstName can not be empty.")
    @Size(min = 2, max = 20, message = "The length of firstName must be between 2 and 20 characters.")
    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("middleName")
    public String middleName;

    @JsonProperty("lastName")
    public String lastName;

    @NotNull(message = "birthDate can not be null.")
    @PastOrPresent(message = "The birth date must be today or past.")
    @JsonProperty("birthDate")
    public Date birthDate;

    @NotNull(message = "userName can not be null.")
    @NotEmpty(message = "userName can not be empty.")
    @Size(min = 5, max = 50, message = "The length of userName must be between 2 and 50 characters.")
    @Pattern(regexp = Constants.userNameRegex, message = "please enter valid user name as per the user policy." + "Include 1 UpperCase & 1 LowerCase Character.Special Character's are not allowed except _,-,@")
    @JsonProperty("userName")
    public String userName;

    @NotNull(message = "password can not be null.")
    @NotEmpty(message = "password can not be empty.")
    @Pattern(regexp = Constants.passwordRegex, message = "please enter valid password," + " Minimum eight characters, at least one letter, one number and one special character.")
    @JsonProperty("password")
    public String password;

    @NotNull(message = "email can not be null.")
    @NotEmpty(message = "email can not be empty.")
    @Email(message = "The email address is invalid.", flags = {Pattern.Flag.CASE_INSENSITIVE})
    @Pattern(regexp = Constants.validEmailRegex, message = "Please enter valid email.")
    @JsonProperty("email")
    public String email;

    @Range(min = 10000000L, max = 999999999999L, message = "The contact no length must be in between 8 to 12 digits.")
    @JsonProperty("contactNo")
    public long contactNo;

    @JsonProperty("branch")
    public String branch;

    @JsonProperty("course")
    public String[] course;

    @Valid
    @JsonProperty("addressDetails")
    public Address addressDetails;

    @Valid
    @NotNull(message = "fatherDetails object can not be null.")
    @JsonProperty("fatherDetails")
    public Father fatherDetails;

    @Valid
    @NotNull(message = "motherDetails object can not be null.")
    @JsonProperty("motherDetails")
    public Mother motherDetails;


    /**
     * The Address in inner class of StudentRequestPayload class type.Which is basically for Address request body logic.
     */
    @Data
    public static class Address {
        @Valid
        @NotNull(message = "permanentAddress can not be null.")
        @JsonProperty("permanentAddress")
        public PermanentAddress permanentAddress;

        @Valid
        @NotNull(message = "communicationAddress can not be null.")
        @JsonProperty("communicationAddress")
        public CommunicationAddress communicationAddress;

        /**
         * The PermanentAddress is inner class of Address Class type.Which is basically for Permanent Address request body logic.
         */
        @Data
        public static class PermanentAddress {
            @NotNull(message = "line1 can not be null.")
            @NotEmpty(message = "line1 can not be empty.")
            @JsonProperty("line1")
            public String line1;

            @NotNull(message = "line2 can not be null.")
            @NotEmpty(message = "line2 can not be empty.")
            @JsonProperty("line2")
            public String line2;

            @JsonProperty("line3")
            public String line3;

            @NotNull(message = "city can not be null.")
            @NotEmpty(message = "city can not be empty.")
            @JsonProperty("city")
            public String city;

            @Range(min = 100000, max = 999999, message = "zipCode should be of length 6.")
            @Positive(message = "Zip code can not be negative.")
            @JsonProperty("zipCode")
            public int zipCode;

            @NotNull(message = "state can not be null.")
            @NotEmpty(message = "state can not be empty.")
            @JsonProperty("state")
            public String state;

            @NotNull(message = "country can not be null.")
            @NotEmpty(message = "country can not be empty.")
            @JsonProperty("country")
            public String country;
        }

        /**
         * The CommunicationAddress is inner class of Address Class type.Which is basically for Permanent Address request body logic.
         */

        @Data
        public static class CommunicationAddress {

            @NotNull(message = "line1 can not be null.")
            @NotEmpty(message = "line1 can not be empty.")
            @JsonProperty("line1")
            public String line1;

            @NotNull(message = "line2 can not be null.")
            @NotEmpty(message = "line2 can not be empty.")
            @JsonProperty("line2")
            public String line2;

            @JsonProperty("line3")
            public String line3;

            @NotNull(message = "city can not be null.")
            @NotEmpty(message = "city can not be empty.")
            @JsonProperty("city")
            public String city;

            @Range(min = 100000, max = 999999, message = "zipCode should be of length 6.")
            @Positive(message = "Zip code can not be negative.")
            @JsonProperty("zipCode")
            public int zipCode;

            @NotNull(message = "state can not be null.")
            @NotEmpty(message = "state can not be empty.")
            @JsonProperty("state")
            public String state;

            @NotNull(message = "country can not be null.")
            @NotEmpty(message = "country can not be empty.")
            @JsonProperty("country")
            public String country;
        }
    }

    /**
     * The Father is inner class of Address Class type.Which is basically for Father details request body logic.
     */
    @Data
    public static class Father {

        @NotNull(message = "Father's firstName can not be null.")
        @NotEmpty(message = "Father's firstName can not be empty.")
        @Size(min = 2, max = 20, message = "The length of firstName must be between 2 and 20 characters.")
        @JsonProperty("firstName")
        public String firstName;

        @JsonProperty("middleName")
        public String middleName;

        @JsonProperty("lastName")
        public String lastName;

        @Range(min = 10000000L, max = 999999999999L, message = "The contact no length must be in between 8 to 12 digits.")
        @JsonProperty("contactNo")
        public long contactNo;

        @JsonProperty("occupation")
        public String occupation;

        @JsonProperty("education")
        public String education;
    }

    /**
     * The Mother is inner class of Address Class type.Which is basically for Mother details request body logic.
     */
    @Data
    public static class Mother {

        @NotNull(message = "Mother's firstName can not be null.")
        @NotEmpty(message = "Mother's firstName can not be empty.")
        @Size(min = 2, max = 20, message = "The length of firstName must be between 2 and 20 characters.")
        @JsonProperty("firstName")
        public String firstName;

        @JsonProperty("middleName")
        public String middleName;

        @JsonProperty("lastName")
        public String lastName;

        @Range(min = 10000000L, max = 999999999999L, message = "The contact no length must be in between 8 to 12 digits.")
        @JsonProperty("contactNo")
        public long contactNo;

        @NotNull(message = "Mother's midName can not be null.")
        @NotEmpty(message = "Mother's midName can not be empty.")
        @JsonProperty("midName")
        public String midName;

        @JsonProperty("occupation")
        public String occupation;

        @JsonProperty("education")
        public String education;
    }

    /**
     * This method will be used to produce the student's name in case middle name is present in request body.
     *
     * @return the student's name.
     */
    public String getStudentName() {
        if (middleName != null && !middleName.trim().isEmpty()) {
            return firstName + " " + middleName + " " + lastName;
        } else {
            return firstName + " " + lastName;
        }
    }
}
