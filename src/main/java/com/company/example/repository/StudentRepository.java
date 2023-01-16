package com.company.example.repository;

import com.company.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

    @Query("SELECT student " +
            "FROM Student student " +
            "JOIN FETCH student.classRoom cl " +
            "WHERE cl.id = ?1")
    List<Student> findStudentByClassId(Long classId);

    @Query("UPDATE Student student SET student.firstName = ?1, student.lastName = ?2 WHERE student.id = ?3")
    @Modifying
    void updateStudentByQuery(String firstName, String lastName, Long id);

    @Query("DELETE FROM Student student WHERE student.id = ?1")
    @Modifying
    void deleteStudentByQuery(Long id);

}
