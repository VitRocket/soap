package com.example.service;

import com.example.dao.StudentRepository;
import com.example.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student getStudent(Integer id) {
        return studentRepository.findById(id);
    }
}
