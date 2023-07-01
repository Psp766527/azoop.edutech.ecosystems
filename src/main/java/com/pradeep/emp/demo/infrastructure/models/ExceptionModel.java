package com.pradeep.emp.demo.infrastructure.models;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * ExceptionModel DAO class is basically for fetching the already registered ExceptionModel's details.
 */
@AllArgsConstructor
public class ExceptionModel {
    @Id
    String id;
    @Indexed
    String eventType;
    String studentRollNo;
    String studentUserName;
    long createdOn;

}
