package com.example.Auth;

import com.example.Auth.Repo.UserRepo;
import com.example.Auth.entity.Role;
import com.example.Auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BootStrap implements ApplicationRunner {

    @Autowired
    UserRepo userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(userRepository.count()<1){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            User user1 = new User();
            user1.setUsername("user");
            user1.setPassword(passwordEncoder.encode("pass"));

            Role role = new Role();
            Role role1 = new Role();
            role.setRole("ROLE_USER");
            role1.setRole("ROLE_ADMIN");
            role.setUser(user1);
            role1.setUser(user1);
            List<Role> roleList= new ArrayList<>();
            roleList.add(role);
            roleList.add(role1);
            user1.setRole(roleList);

            User user2 = new User();
            user2.setUsername("admin");
            user2.setPassword(passwordEncoder.encode("pass"));
            Role role2 = new Role();
            role2.setRole("ROLE_ADMIN");
            role2.setUser(user2);
            List<Role> roleList1= new ArrayList<>();
            roleList1.add(role2);
            user2.setRole(roleList1);

            userRepository.save(user1);
            userRepository.save(user2);

            System.out.println("Total users saved::"+userRepository.count());

        }
    }
}