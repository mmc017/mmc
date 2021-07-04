package com.example.bootstudy.service;

import com.example.bootstudy.entity.Student;

public interface StudentService {
    int add(Student student);
    int update(Student student);
    int deleteBysno(String sno);
    Student queryStudentBySno(String sno);


    Student queryStudentBySno1(String sno);
    Student queryStudentBySno2(String sno);

    void add1(Student student);


    void add2(Student student);
}
