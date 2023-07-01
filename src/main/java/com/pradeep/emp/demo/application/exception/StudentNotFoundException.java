package com.pradeep.emp.demo.application.exception;

import org.springframework.data.crossstore.ChangeSetPersister;

public class StudentNotFoundException extends ChangeSetPersister.NotFoundException {

    public StudentNotFoundException() {

    }
}
