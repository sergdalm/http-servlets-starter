package com.sergdalm.http.util;

import lombok.experimental.UtilityClass;

// Это константа наших путей, которая содержит открытые страницы.
// Их мы будем использовать в адресах сервлетов
@UtilityClass
public class UrlPath {
    public static final String LOGIN = "/login";
    public static final String REGISTRATION = "/registration";
    public static final String IMAGES = "/images";
}
