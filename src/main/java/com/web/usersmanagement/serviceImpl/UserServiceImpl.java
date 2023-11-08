package com.web.usersmanagement.serviceImpl;

import com.web.usersmanagement.exception.UserNotFoundException;
import com.web.usersmanagement.model.User;
import com.web.usersmanagement.repository.UserRepository;
import com.web.usersmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        newUser.setTypeRole(user.getTypeRole());
        newUser.setPassword(user.getPassword());
        return userRepository.save(newUser);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @Override
    public User updateUser(Long id, User newUser) {
        return userRepository.findById(id)
         .map(user -> {
        user.setName(newUser.getName());
        newUser.setSurname(newUser.getSurname());
        newUser.setEmail(newUser.getEmail());
        newUser.setTypeRole(newUser.getTypeRole());
        newUser.setPassword(newUser.getPassword());
        return userRepository.save(newUser);
         }).orElseThrow(()-> new UserNotFoundException(id));
    }
    @Override
    public String deleteUser(Long id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "Informations sur User avec id: "+id+"a supprimé avec succès.";
    }
}
