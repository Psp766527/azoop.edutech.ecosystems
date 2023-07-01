package com.pradeep.emp.demo.application.student.models;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class StudentResponsePayload {
    String userName;
    String rollNo;
    Date createdOn;
    String createdBy;
}
