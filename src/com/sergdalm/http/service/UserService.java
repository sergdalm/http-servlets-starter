package com.sergdalm.http.service;

import com.sergdalm.http.dao.UserDao;
import com.sergdalm.http.dto.CreateUserDto;
import com.sergdalm.http.dto.UserDto;
import com.sergdalm.http.entity.User;
import com.sergdalm.http.exception.ValidationException;
import com.sergdalm.http.mapper.CreateUserMapper;
import com.sergdalm.http.mapper.UserMapper;
import com.sergdalm.http.validator.CreateUserValidator;
import com.sergdalm.http.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(userMapper::mapFrom);
    }

    @SneakyThrows
    public Integer create(CreateUserDto userDto) {
        // validation
        ValidationResult validationResult = createUserValidator.isValid(userDto);

        // В реальных приложениях возвращаемое значение было бы не Integer,
        // а что-то вроде Either, в котором был бы либо результат успешного выполнения,
        // либо ошибки.
        // В данном случае вместо этого мы просто пробрасываем exception.

        // mapping
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }

        // userDao.save
        User userEntity = createUserMapper.mapFrom(userDto);

        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
        // По-хорошему надо сохранить юзера и картинку, в противном случае нам надо откатить транзакцию
        // если что-то из этого не получилось сделать
        // В реальных приложениях удобно открывать транзакцию на уровне сервисов.
        // Но это усложняет нашу логику, поэтому тут мы сделаем по-простому:
        // сначала сохраним картинку, а потом сущность, потому что есл мы сначала сохраним сущность, а картинку
        // сохранить не получится - это будет намного хуже.
        userDao.save(userEntity);

        // return id
        return userEntity.getId();

    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
