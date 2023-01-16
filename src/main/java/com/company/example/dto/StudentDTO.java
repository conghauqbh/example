package com.company.example.dto;

import com.company.example.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class StudentDTO {

    private Long id;

    @NotBlank(message = "First name can't be blank")
    private String firstName;

    private String lastName;

    @NotBlank
    private String dateOfBirth;

    private String address;

    @NotBlank(message = "Phone can't be blank")
    private String phone;

    @NotBlank(message = "Email can't be blank")
    private String email;

    private ClassRoomDTO classRoom;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.dateOfBirth = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(student.getDateOfBirth());
        this.address = student.getAddress();
        this.phone = student.getPhone();
        this.email = student.getEmail();
        this.classRoom = new ClassRoomDTO(student.getClassRoom());
    }

    public void toStudent(Student student) {
        student.setFirstName(this.firstName);
        student.setLastName(this.lastName);
        student.setEmail(this.email);
        student.setPhone(this.phone);
        student.setAddress(this.address);
        student.setDateOfBirth(LocalDate.parse(this.dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
