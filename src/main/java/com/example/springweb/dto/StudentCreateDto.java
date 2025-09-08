package com.example.springweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateDto {
    private String name;
    private Integer age;
    private String email;
    private Set<Long> courseIds;
}
