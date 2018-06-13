package com.example.soap.util;

import com.example.domain.Student;
import com.example.soap.model.StudentModel;

public class StudentUtil {

    public static StudentModel domainToModel(Student student) {
        StudentModel studentModel = new StudentModel();
        studentModel.setId(student.getId());
        studentModel.setName(student.getName());
        studentModel.setEmail(student.getEmail());
        studentModel.setAddress(AddressUtil.domainToModel(student.getAddress()));
        return studentModel;
    }

}
