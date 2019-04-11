package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.controller.find.QuerySpecification;
import service.admin.model.user.UserRoles;
import service.admin.repositories.UserRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService implements EntityService<UserRoles> {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRoles save(UserRoles userRole) {

        return userRoleRepository.save(userRole);

    }

    public List<UserRoles> find(QuerySpecification<UserRoles> userSpecification) {

        return userRoleRepository.findAll(userSpecification);

    }

    public Optional<UserRoles> get(String id) {

        return null;

    }

    public boolean delete(String code) {

        Optional<UserRoles> role = get(code);

        if (role.isPresent()) {

            userRoleRepository.delete(role.get());

            return true;
        }

        return false;
    }

    public List<UserRoles> getAll() {

        return userRoleRepository.findAll();
    }

}
