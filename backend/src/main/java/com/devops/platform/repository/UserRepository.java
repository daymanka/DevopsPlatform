package com.devops.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devops.platform.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}