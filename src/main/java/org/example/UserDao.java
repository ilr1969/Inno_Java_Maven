/*
package org.example;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    private final DataSource dataSource;

    @Autowired
    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User create(User user) throws SQLException {
        String sql = "INSERT INTO users (username) VALUES (?) RETURNING id";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getLong("id"));
                return user;
            } else {
                throw new SQLException("Не удалось получить пользователя из БД по id");
            }
        }
    }

    public String findById(Long id) throws SQLException {
        String sql = "SELECT id, username FROM users WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "Под id=" + rs.getLong("id") + " у нас пользователь с именем " + rs.getString("username") + ".";
            } else {
                return "Пользователь с id=" + id + " не найден.";
            }
        }
    }

    public List<User> findAll() throws SQLException {
        String sql = "SELECT id, username FROM users";
        List<User> users = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                users.add(new User(rs.getLong("id"), rs.getString("username")));
            }
        }
        return users;
    }

    public boolean clearTable() throws SQLException {

        String sql = "TRUNCATE TABLE users";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(Long id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            System.out.println("Удаляем пользователя с id=" + id);
            return ps.executeUpdate() > 0;
        }
    }
}

*/
