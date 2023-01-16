package com.company.example.api;

import com.company.example.dto.StudentDTO;
import com.company.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api")
public class StudentApi {

    private final StudentService studentService;

    public StudentApi(StudentService studentService) { // Injected
        this.studentService = studentService;
    }

    @GetMapping("students")
    public ResponseEntity<?> getListStudent() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("students-by-class")
    public ResponseEntity<?> getStudentsByClassId(@RequestParam("classId") Long classId) {
        return ResponseEntity.ok(studentService.getStudentsByClassId(classId));
    }

    @GetMapping("find-students")
    public ResponseEntity<?> getStudents(@RequestParam("name") String name) {
        return ResponseEntity.ok(studentService.findStudentByName(name));
    }

    @PostMapping("student")
    public ResponseEntity<?> saveStudent(@RequestBody @Valid  StudentDTO studentDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        StudentDTO result = studentService.saveStudent(studentDTO);
        return ResponseEntity.created(URI.create("student/"+result.getId())).body(result);
    }

    @PutMapping("student")
    public ResponseEntity<?> editStudent(@RequestBody @Valid StudentDTO studentDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        StudentDTO result = studentService.saveStudent(studentDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }


}
