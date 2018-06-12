package com.example.dao;

import com.example.domain.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private Map<Integer, Student> studentMap = new HashMap<>();
    private Integer index = 0;

    @PostConstruct
    private void defaultValue() {
        addStudent(new Student("Ivan", "ivan@email.com"));
        addStudent(new Student("Mike", "mike@email.com"));
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
