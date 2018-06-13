package com.example.dao;

import com.example.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {

    private final AddressRepository addressRepository;

    private Map<Integer, Student> studentMap = new HashMap<>();
    private Integer index = 0;

    @PostConstruct
    private void defaultValue() {
        Student student = new Student("Ivan", "ivan@email.com");
        student.setAddress(addressRepository.findById(1));
        addStudent(student);
        student = new Student("Mike", "mike@email.com");
        student.setAddress(addressRepository.findById(1));
        addStudent(student);
    }

    private void addStudent(Student student) {
        student.setId(++index);
        studentMap.put(student.getId(), student);
    }

    @Override
    public Student findById(Integer id) {
        return studentMap.get(id);
    }
}
