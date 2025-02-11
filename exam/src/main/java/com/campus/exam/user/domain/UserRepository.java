package com.campus.exam.user.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long>{

    boolean existsByEmail(String email);

    User save(User user);

    User findByEmail(String email);
    Optional<User> findById(Long user);

}
