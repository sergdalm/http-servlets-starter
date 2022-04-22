package com.sergdalm.http.validator;

import com.sergdalm.http.dao.UserDao;
import com.sergdalm.http.dto.CreateUserDto;
import com.sergdalm.http.entity.Gender;
import com.sergdalm.http.entity.Role;
import com.sergdalm.http.util.LocalDateFormatter;

import java.util.regex.Pattern;


public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();
        if(object.getName().length() == 0) {
            validationResult.add(Error.of("invalid.name", "Name is invalid"));
        }
        if(!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid.birthday", "Birthday is invalid"));
        }
        if(object.getEmail() == null || !(object.getEmail().contains("@")) || !(object.getEmail().contains("."))) {
            validationResult.add(Error.of("invalid.email", "Email is invalid"));
        }
        if(object.getPassword().length() < 4) {
            validationResult.add(Error.of("invalid.password", "Password is invalid"));
        }
        if(Gender.find(object.getGender()).isEmpty()) {
            validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
        }
        if(Role.find(object.getRole()).isEmpty()) {
            validationResult.add(Error.of("invalid.role", "Role is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
