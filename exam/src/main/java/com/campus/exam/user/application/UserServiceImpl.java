package com.campus.exam.user.application;

import com.campus.exam.user.domain.RegisterDTO;
import com.campus.exam.user.domain.User;
import com.campus.exam.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterDTO registerDTO) {
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User User = new User();
        User.setName(registerDTO.getName());
        User.setEmail(registerDTO.getEmail());
        User.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        return userRepository.save(User);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean verifyByEmail(String email, String password) {
        User User = getUserByEmail(email);
        if (User == null) {
            return false;
        }
        return passwordEncoder.matches(password, User.getPassword());
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
