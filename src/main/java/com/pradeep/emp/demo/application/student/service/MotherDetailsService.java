package com.pradeep.emp.demo.application.student.service;

import com.pradeep.emp.demo.application.student.models.StudentRequestPayload;
import com.pradeep.emp.demo.domain.entities.student.valueObjects.Mother;
import org.springframework.stereotype.Service;

@Service
public class MotherDetailsService {

    public Mother getMotherDetails(StudentRequestPayload.Mother mother) {
        return new Mother(mother.firstName, mother.middleName, mother.lastName, mother.contactNo, mother.midName,
                mother.occupation, mother.education);

    }
}
