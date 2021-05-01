package edu.miu.util;

import edu.miu.domain.Role;
import edu.miu.domain.User;
import edu.miu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Role roleFaculty = new Role(100, "ROLE_FACULTY");
        Role roleStudent = new Role(200, "STUDENT");

        Set<Role> roleSet1 = new HashSet<>();
        Set<Role> roleSet2 = new HashSet<>();

        roleSet1.add(roleFaculty);
        roleSet2.add(roleStudent);

        User user1 = new User(10, "student",bCryptPasswordEncoder.encode("student"),1,roleSet2);
        User user2 = new User(35, "faculty",bCryptPasswordEncoder.encode("faculty"),1, roleSet1);

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
