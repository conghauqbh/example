package com.company.example.dto;

import com.company.example.entity.ClassRoom;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClassRoomDTO {

    private Long id;

    private String name;

    public ClassRoomDTO(ClassRoom classRoom) {
        this.id = classRoom.getId();
        this.name = classRoom.getName();
    }
}
