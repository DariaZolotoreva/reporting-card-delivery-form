package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты

    public static String generateCity() {
        var cities = new String[] {"Москва", "Санкт-Петербург", "Воронеж", "Пенза", "Владивосток"};
        return cities[new Random().nextInt(cities.length)];
    }
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random


    public static String generateName(String locale) {
        var faker = new Faker (new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateWrongPhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().cellPhone();
    }
    public static class Registration {
        private Registration() {

        }
        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(),generateName(locale),generatePhone(locale));
        }
    }

// TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
    // generateName(locale), generatePhone(locale)


        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
}