package example;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("example");

        UserService userService = context.getBean(UserService.class);

        System.out.println("=== Чистим таблицу на случай существования пользователей с прошлого дебага ===" + "\n");
        userService.clearTable();

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
        boolean deleted = userService.deleteUser(u2.getId());
        System.out.println("Deleted: " + deleted);

        System.out.println("\n=== Итоговый список пользователей ===");
        userService.getAllUsers().forEach(System.out::println);

        context.close();
    }
}
