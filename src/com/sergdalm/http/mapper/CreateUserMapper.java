package com.sergdalm.http.mapper;

import com.sergdalm.http.dto.CreateUserDto;
import com.sergdalm.http.entity.Gender;
import com.sergdalm.http.entity.Role;
import com.sergdalm.http.entity.User;
import com.sergdalm.http.util.LocalDateFormatter;

import java.util.Random;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();
    private static final String IMAGE_FOLDER = "users/";
    // для добавления уникального префикса
    private static final Random RANDOM = new Random();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .image(IMAGE_FOLDER + RANDOM.nextInt() + object.getImage().getSubmittedFileName())
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
