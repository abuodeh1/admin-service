package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.user.UserRoles;
import service.admin.repositories.UserRoleRepository;

@Service
public class UserRoleService extends AbstractEntityService<UserRoles> {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRoleRepository getRepository() {
        return userRoleRepository;
    }

    @Override
    public UserRoles beforeSave(UserRoles userRoles) {
        return userRoles;
    }

}
