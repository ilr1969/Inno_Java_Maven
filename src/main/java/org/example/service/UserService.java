package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void clearTable() throws SQLException {
        userRepository.deleteAll();
    }

    public User createUser(String username) throws SQLException {
        User user = new User(username);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) throws SQLException {
        userRepository.deleteById(id);
    }

    public String getUser(Long id) {
        try {
            return userRepository.findById(id).get().getUsername();
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }

    public List<User> getAllUsers() throws SQLException {
        return userRepository.findAll();
    }

}
