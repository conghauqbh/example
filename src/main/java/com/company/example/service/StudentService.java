package com.company.example.service;

import com.company.example.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getStudents();

    List<StudentDTO> getStudentsByClassId(Long classId);

    List<StudentDTO> findStudentByName(String name);

    StudentDTO saveStudent(StudentDTO student);

    void deleteStudent(Long studentId);

}
