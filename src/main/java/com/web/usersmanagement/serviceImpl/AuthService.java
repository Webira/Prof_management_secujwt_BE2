package com.web.usersmanagement.serviceImpl;

import com.web.usersmanagement.model.User;
import com.web.usersmanagement.model.UserInfo;
import com.web.usersmanagement.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "user added to system ";
    }

    public List<UserInfo> getAllUsersInfo() {
        return userInfoRepository.findAll();
    }
}
