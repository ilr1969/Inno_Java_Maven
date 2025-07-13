package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean clearTable() throws SQLException {
        return userDao.clearTable();
    }

    public User createUser(String username) throws SQLException {
        User user = new User(username);
        return userDao.create(user);
    }

    public boolean deleteUser(Long id) throws SQLException {
        return userDao.delete(id);
    }

    public String getUser(Long id) throws SQLException {
        return userDao.findById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDao.findAll();
    }
}
