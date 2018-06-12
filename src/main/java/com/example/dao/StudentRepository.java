package com.example.dao;

import com.example.domain.Student;

public interface StudentRepository {

    Student findById(Integer id);

}
