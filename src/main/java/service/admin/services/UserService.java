package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import service.admin.model.privilege.Privilege;
import service.admin.model.role.Role;
import service.admin.model.user.User;
import service.admin.repositories.UserPrivilegesRepository;
import service.admin.repositories.UserRepository;
import service.admin.repositories.UserRoleRepository;

import java.util.List;

@Service
public class UserService extends AbstractEntityService<User> implements EntityServicePhase<User> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPrivilegesRepository userPrivilegesRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public List<Privilege> getUserPrivilegesByUserCode(String code) {

        return userPrivilegesRepository.getUserPrivilegesByUserCode(code);
    }

    @Override
    public UserRepository getRepository() {

        return userRepository;
    }

    @Override
    public User beforeSave(User user) {

        user.setPassword(passwordEncoder().encode(user.getPassword()));

        return user;
    }

    public List<Role> getUserRolesByUserCode(String code){

        return userRoleRepository.getUserRolesByUserCode(code);
    }


}
