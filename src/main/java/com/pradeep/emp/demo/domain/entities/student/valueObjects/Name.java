package com.pradeep.emp.demo.domain.entities.student.valueObjects;

import lombok.Value;

@Value
public class Name {

    String value;

    public Name(String value) throws IllegalAccessException {

        if (value == null || value.trim().isEmpty())
            throw new IllegalAccessException("The name cannot be null or empty.");

        this.value = value;

    }

}
