package com.example.onlinetest.component;


import com.example.onlinetest.entity.User;
import com.example.onlinetest.entity.enums.Role;
import com.example.onlinetest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
//
//    final PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String mode;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;


    final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        if (ddl.equals("create") && mode.equals("always")) {
            User user = new User();
            user.setUsername("user");
//            user.setPassword(passwordEncoder.encode("user"));
            user.setPassword("user");
            user.setRole(Role.USER);
            userRepository.save(user);

            User admin = new User();
            admin.setRole(Role.ADMIN);
            admin.setUsername("admin");
//            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setPassword("admin");
            userRepository.save(admin);
        }


    }
}
