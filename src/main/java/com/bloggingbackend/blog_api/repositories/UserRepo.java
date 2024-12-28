package com.bloggingbackend.blog_api.repositories;

import com.bloggingbackend.blog_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
