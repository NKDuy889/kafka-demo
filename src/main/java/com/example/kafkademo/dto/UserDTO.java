package com.example.kafkademo.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserDTO {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}