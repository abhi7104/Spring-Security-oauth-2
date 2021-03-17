package com.example.Auth.Dao;

import com.example.Auth.Auth.AppUser;
import com.example.Auth.Auth.GrantAuthorityImpl;
import com.example.Auth.Repo.UserRepo;
import com.example.Auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class UserDao {

    @Autowired
    UserRepo userRepo;
    public AppUser loadUserByUserName(String username)
    {
        User user= userRepo.findByUsername(username);
        System.out.println(user);
        if(username!= null)
        {
            return new AppUser(user.getUsername(),user.getPassword(),
                    Arrays.asList(new GrantAuthorityImpl(user.getRole())));
        }
        else {
            throw new RuntimeException();
        }
    }
}
