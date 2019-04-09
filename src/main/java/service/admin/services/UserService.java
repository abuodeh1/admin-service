package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import service.admin.controller.find.QuerySpecification;
import service.admin.model.user.User;
import service.admin.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements EntityService<User> {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User save(User user) {

        user.setPassword(passwordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public List<User> find(QuerySpecification<User> querySpecification) {

        return userRepository.findAll(querySpecification);
    }

    @Override
    public Optional<User> get(String username) {

        return userRepository.findUserByCode(username);
    }

    public boolean delete(String username) {

        Optional<User> user = get(username);

        if (user.isPresent()) {

            userRepository.delete(user.get());

            return true;
        }

        return false;
    }

    public List<User> getAll() {

        return userRepository.findAll();
    }

    public List<String> getPriviledgeCodes(String username) {


        return userRepository.getPriviledgeCodes(username);
    }
}
