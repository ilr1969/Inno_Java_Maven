package org.example;


import org.example.model.User;
import org.example.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"org.example"})
@EnableJpaRepositories(basePackages = "org.example.repository")
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(Main.class);

        UserService userService = context.getBean(UserService.class);

        System.out.println("=== Чистим таблицу на случай существования пользователей с прошлого дебага ===" + "\n");
        //userService.clearTable();

        System.out.println("=== Создаем пользователей ===");
        User u1 = userService.createUser("Петя");
        User u2 = userService.createUser("Маша");
        System.out.println(u1);
        System.out.println(u2);

        System.out.println("\n=== Получаем всех пользователей ===");
        List<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);

        System.out.println("\n=== Получаем пользователя по ID ===");
        System.out.println(userService.getUser(u1.getId())); //возвращаем первого имеющегося для наглядности
        System.out.println(userService.getUser(100L)); //возвращаем id=100, которого не должно быть в БД

        System.out.println("\n=== Удаляем пользователя ===");
        userService.deleteUser(u2.getId());
        System.out.println("Deleted: " + u2.getId());

        System.out.println("\n=== Итоговый список пользователей ===");
        userService.getAllUsers().forEach(System.out::println);
    }
}


