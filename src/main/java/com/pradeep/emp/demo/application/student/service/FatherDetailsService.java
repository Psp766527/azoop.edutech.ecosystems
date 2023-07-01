package com.pradeep.emp.demo.application.student.service;

import com.pradeep.emp.demo.application.student.models.StudentRequestPayload;
import com.pradeep.emp.demo.domain.entities.student.valueObjects.Father;
import org.springframework.stereotype.Service;

@Service
public class FatherDetailsService {

    public Father getFatherDetails(StudentRequestPayload.Father father) {
        return new Father(father.firstName, father.middleName, father.lastName, father.contactNo, father.occupation,
                father.education);
    }
}
