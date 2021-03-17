package com.example.Auth.Repo;

import com.example.Auth.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {
    User findByUsername(String username);
}
