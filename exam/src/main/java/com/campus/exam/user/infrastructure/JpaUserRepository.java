
package com.campus.exam.user.infrastructure;

import com.campus.exam.user.domain.User;
import com.campus.exam.user.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Long>, UserRepository{
    
}
