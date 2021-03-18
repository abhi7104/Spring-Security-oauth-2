package com.example.Auth.Dao;

import com.example.Auth.Auth.AppUser;
import com.example.Auth.Auth.GrantAuthorityImpl;
import com.example.Auth.Repo.UserRepo;
import com.example.Auth.entity.Role;
import com.example.Auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    UserRepo userRepo;
    public AppUser loadUserByUserName(String username)
    {
        User user= userRepo.findByUsername(username);
        if(username!= null)
        {
            List<Role> roles = user.getRole();
            List<GrantAuthorityImpl> grantAuthorityList = new ArrayList<GrantAuthorityImpl>();
            for(Role role: roles){
                grantAuthorityList.add(new GrantAuthorityImpl(role.getRole()));
            }
            return new AppUser(user.getUsername(),user.getPassword(), grantAuthorityList);
        }
        else {
            throw new RuntimeException();
        }
    }
}
