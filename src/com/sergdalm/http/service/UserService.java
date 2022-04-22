package com.sergdalm.http.service;

import com.sergdalm.http.dao.UserDao;
import com.sergdalm.http.dto.CreateUserDto;
import com.sergdalm.http.entity.User;
import com.sergdalm.http.exception.ValidationException;
import com.sergdalm.http.mapper.CreateUserMapper;
import com.sergdalm.http.validator.CreateUserValidator;
import com.sergdalm.http.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper userMapper = CreateUserMapper.getInstance();


    public Integer create(CreateUserDto userDto) {
        // validation
        ValidationResult validationResult = createUserValidator.isValid(userDto);

        // В реальных приложениях возвращаемое значение было бы не Integer,
        // а что-то вроде Either, в котором был бы либо результат успешного выполнения,
        // либо ошибки.
        // В данном случае вместо этого мы просто пробрасываем exception.

        // mapping
        if(!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }

        // userDao.save
        User userEntity = userMapper.mapFrom(userDto);
        userDao.save(userEntity);

        // return id
        return userEntity.getId();

    }

   public static UserService getInstance() {
        return INSTANCE;
    }
}
