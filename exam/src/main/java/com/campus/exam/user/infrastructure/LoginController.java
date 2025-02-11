
package com.campus.exam.user.infrastructure;
import com.campus.exam.security.JWTAuthtenticationConfig;
import com.campus.exam.user.application.UserServiceImpl;
import com.campus.exam.user.domain.LoginResponseDTO;
import com.campus.exam.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    @Autowired
    private JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

        if (userService.verifyByEmail(email, password)) {
            String token = jwtAuthtenticationConfig.getJWTToken(email);

            User user = userService.findByEmail(email);

            LoginResponseDTO responseDTO = new LoginResponseDTO();
            responseDTO.setToken(token);
            responseDTO.setId(user.getId());
            responseDTO.setName(user.getName());
            responseDTO.setEmail(user.getEmail());
            responseDTO.setAdmin(user.getAdmin());
            

            return ResponseEntity.ok(responseDTO);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}