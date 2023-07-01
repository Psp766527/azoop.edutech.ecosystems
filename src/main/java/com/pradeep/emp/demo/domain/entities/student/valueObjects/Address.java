package com.pradeep.emp.demo.domain.entities.student.valueObjects;

import com.mongodb.lang.NonNull;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This class is responsible for the entry of permanent & communication address.
 */
public class Address {

    @Field("permanentAddress")
    public PermanentAddress permanentAddress;
    @Field("communicationAddress")
    public CommunicationAddress communicationAddress;

    public Address(PermanentAddress permanentAddress, CommunicationAddress communicationAddress) {
        this.permanentAddress = permanentAddress;
        this.communicationAddress = communicationAddress;
    }

    /**
     * The PermanentAddress is inner class of Address Class type.Which is basically for Permanent Address persistence logic.
     */
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

        public PermanentAddress(String line1, String line2, String line3, String city, int zipCode, String state,
                                String country) {
            this.line1 = line1;
            this.line2 = line2;
            this.line3 = line3;
            this.city = city;
            this.zipCode = zipCode;
            this.state = state;
            this.country = country;
        }
    }

    /**
     * The CommunicationAddress is inner class of Address Class type.Which is basically for Permanent Address persistence logic.
     */
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

        public CommunicationAddress(String line1, String line2, String line3, String city, int zipCode, String state,
                                    String country) {
            this.line1 = line1;
            this.line2 = line2;
            this.line3 = line3;
            this.city = city;
            this.zipCode = zipCode;
            this.state = state;
            this.country = country;
        }
    }
}
