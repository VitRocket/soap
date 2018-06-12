package com.example.soap;

import com.example.domain.Student;
import com.example.service.StudentService;
import com.example.soap.student.StudentModel;
import com.example.soap.student.StudentRequest;
import com.example.soap.student.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class StudentEndpoint {

    private final StudentService studentService;

    @PayloadRoot(namespace = "http://example.com/soap/student", localPart = "StudentRequest")
    @ResponsePayload
    public StudentResponse getStudent(@RequestPayload StudentRequest request) {
        Student student = studentService.getStudent(request.getId());
        StudentModel studentModel = defineStudentModel(student);
        StudentResponse response = new StudentResponse();
        response.setStudent(studentModel);
        return response;
    }

    private StudentModel defineStudentModel(Student student) {
        StudentModel studentModel = new StudentModel();
        studentModel.setId(student.getId());
        studentModel.setName(student.getName());
        studentModel.setEmail(student.getEmail());
        return studentModel;
    }

}