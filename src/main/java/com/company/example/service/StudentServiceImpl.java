package com.company.example.service;

import com.company.example.dto.ClassRoomDTO;
import com.company.example.dto.StudentDTO;
import com.company.example.entity.ClassRoom;
import com.company.example.entity.Student;
import com.company.example.repository.ClassRoomRepository;
import com.company.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service("studentServiceImpl")
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final ClassRoomRepository classRoomRepository;

    public StudentServiceImpl(StudentRepository studentRepository, ClassRoomRepository classRoomRepository) {
        this.studentRepository = studentRepository;
        this.classRoomRepository = classRoomRepository;
    }


    @Override
    public List<StudentDTO> getStudents() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsByClassId(Long classId) {
        List<Student> students = studentRepository.findStudentByClassId(classId);
        return students
                .stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> findStudentByName(String name) {
        List<Student> students = studentRepository.findStudentByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
        return students
                .stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student;
        if(studentDTO.getId() == null) {
            student = new Student();
        } else {
            student = studentRepository.findById(studentDTO.getId()).orElseThrow(() -> new RuntimeException("Not found student"));
        }
        studentDTO.toStudent(student);
        ClassRoomDTO classRoomDTO = studentDTO.getClassRoom();
        if(classRoomDTO != null && classRoomDTO.getId() != null) {
            ClassRoom classRoom = classRoomRepository.findById(classRoomDTO.getId()).orElseThrow(() -> new RuntimeException("Could not find class room for student"));
            student.setClassRoom(classRoom);
        }
        student = studentRepository.save(student);
        return new StudentDTO(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Could not find student"));
        studentRepository.deleteStudentByQuery(student.getId());
    }

}
