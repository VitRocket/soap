package com.example.soap;

import com.example.domain.Student;
import com.example.service.StudentService;
import com.example.soap.model.StudentModel;
import com.example.soap.model.StudentRequest;
import com.example.soap.model.StudentResponse;
import com.example.soap.util.StudentUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class StudentEndpoint {

    private final StudentService studentService;

    @PayloadRoot(namespace = "http://example.com/soap/model", localPart = "StudentRequest")
    @ResponsePayload
    public StudentResponse getStudent(@RequestPayload StudentRequest request) {
        Student student = studentService.getStudent(request.getId());
        StudentModel studentModel = StudentUtil.domainToModel(student);
        StudentResponse response = new StudentResponse();
        response.setStudent(studentModel);
        return response;
    }
}