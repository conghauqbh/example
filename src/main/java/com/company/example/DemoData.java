package com.company.example;

import com.company.example.entity.ClassRoom;
import com.company.example.entity.Student;
import com.company.example.repository.ClassRoomRepository;
import com.company.example.repository.StudentRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DemoData {

    private final ClassRoomRepository classRoomRepository;

    private final StudentRepository studentRepository;

    public DemoData(ClassRoomRepository classRoomRepository, StudentRepository studentRepository) {
        this.classRoomRepository = classRoomRepository;
        this.studentRepository = studentRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        ClassRoom classRoom1 = new ClassRoom();
        classRoom1.setId(1L);
        classRoom1.setName("Class Room demo 1");
        ClassRoom classRoom2 = new ClassRoom();
        classRoom2.setId(2L);
        classRoom2.setName("Class Room demo 2");

        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Emily");
        student1.setLastName("Smith");
        student1.setDateOfBirth(LocalDate.now().minusYears(10));
        student1.setEmail("Emily@gmail.com");
        student1.setPhone("555");
        student1.setAddress("England");
        student1.setClassRoom(classRoom1);
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setId(2L);
        student2.setFirstName("Jennifer");
        student2.setLastName("Smith");
        student2.setDateOfBirth(LocalDate.now().minusYears(15));
        student2.setEmail("Jennifer@gmail.com");
        student2.setPhone("666");
        student2.setAddress("England");
        student2.setClassRoom(classRoom1);
        student2.setClassRoom(classRoom2);
        studentRepository.save(student2);

    }
}
