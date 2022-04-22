package com.sergdalm.http.mapper;

import com.sergdalm.http.dto.CreateUserDto;
import com.sergdalm.http.entity.Gender;
import com.sergdalm.http.entity.Role;
import com.sergdalm.http.entity.User;
import com.sergdalm.http.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();


    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
