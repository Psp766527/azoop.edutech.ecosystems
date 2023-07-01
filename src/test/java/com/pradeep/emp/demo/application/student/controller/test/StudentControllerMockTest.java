package com.pradeep.emp.demo.application.student.controller.test;

import com.pradeep.emp.demo.application.student.models.StudentRequestPayload;
import com.pradeep.emp.demo.application.student.service.AddressService;
import com.pradeep.emp.demo.application.student.service.FatherDetailsService;
import com.pradeep.emp.demo.application.student.service.MotherDetailsService;
import com.pradeep.emp.demo.infrastructure.studentRepository.StudentServiceRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class StudentControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentServiceRepo studentServiceRepo;
    @InjectMocks
    private AddressService addressService;
    @InjectMocks
    private FatherDetailsService fatherDetailsService;
    @InjectMocks
    private MotherDetailsService motherDetailsService;

    @Test
    public void registerStudent() throws Exception {

        StudentRequestPayload studentRequestPayload = StudentRequestPayload.builder()
                .firstName("Pradeep")
                .middleName("Singh")
                .lastName("Kushwah")
                .birthDate("10/08/1997")
                .
    }
}
