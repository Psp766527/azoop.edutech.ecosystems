package com.pradeep.emp.demo.infrastructure.models.student.valueObjects;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This class is responsible for the entry of permanent & communication address.
 */
@AllArgsConstructor

public class Address {

    @Field("permanentAddress")
    public PermanentAddress permanentAddress;
    @Field("communicationAddress")
    public CommunicationAddress communicationAddress;

    /**
     * The PermanentAddress is inner class of Address Class type.Which is basically for Permanent Address persistence logic.
     */
    @AllArgsConstructor
    public static class PermanentAddress {

        @Field("line1")
        public String line1;
        @Field("line2")
        public String line2;
        @Field("line3")
        @NonNull
        public String line3;
        @Field("city")
        public String city;
        @Field("zipCode")
        public int zipCode;
        @Field("state")
        public String state;
        @Field("country")
        public String country;

    }

    /**
     * The CommunicationAddress is inner class of Address Class type.Which is basically for Permanent Address persistence logic.
     */
    @AllArgsConstructor
    public static class CommunicationAddress {

        @Field("line1")
        public String line1;
        @Field("line2")
        public String line2;
        @Field("line3")
        public String line3;
        @Field("city")
        public String city;
        @Field("zipCode")
        public int zipCode;
        @Field("state")
        public String state;
        @Field("country")
        public String country;

    }
}
