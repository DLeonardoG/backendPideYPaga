
package com.campus.exam.user.infrastructure;

import com.campus.exam.user.application.UserServiceImpl;
import com.campus.exam.user.domain.RegisterDTO;
import com.campus.exam.user.domain.User;
import com.campus.exam.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        try {
            if (userRepository.existsByEmail(registerDTO.getEmail())) {
                throw new IllegalArgumentException("Email already exists");
            }

            User savedUser = userService.register(registerDTO);

            return ResponseEntity.ok("User registrado exitosamente: " + savedUser.getEmail());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al registrar el User.");
        }
    }
}