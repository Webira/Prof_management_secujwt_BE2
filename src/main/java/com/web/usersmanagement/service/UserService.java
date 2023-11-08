package com.web.usersmanagement.service;

import com.web.usersmanagement.model.User;
import java.util.List;
public interface UserService {

    public List<User> getAllUsers();
    public User createUser(User user);
    public User getUserById(Long id);
    public User updateUser(Long id, User user);
    public String deleteUser(Long id);
}
