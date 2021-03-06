package com.example.Auth.Service;

import com.example.Auth.Auth.AppUser;
import com.example.Auth.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailService implements UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String encryptedPassword=passwordEncoder.encode("pass");
        System.out.println("Trying to authenticate user:-------- "+username);
        System.out.println("Encrypted Password:-------- "+encryptedPassword);
        UserDetails userDetails=userDao.loadUserByUserName(username);
        return userDetails;
    }
}
