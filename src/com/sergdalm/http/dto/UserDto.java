package com.sergdalm.http.dto;

import com.sergdalm.http.entity.Gender;
import com.sergdalm.http.entity.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Integer id;
    String email;
    String name;
    LocalDate birthday;
    String image;
    Role role;
    Gender gender;
}
