package com.sergdalm.http.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Role {
    USER,
    ADMIN;

    // Так как роль была не обязательное поле, т метод find()
    // возвращает Optional, в случае отсутствия роли установить null
    public static Optional<Role> find(String role) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(role))
                .findFirst();
    }
}
