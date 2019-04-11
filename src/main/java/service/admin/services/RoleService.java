package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.role.Role;
import service.admin.repositories.RoleRepository;

@Service
public class RoleService extends AbstractEntityService<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleRepository getRepository() {
        return roleRepository;
    }

    @Override
    public Role beforeSave(Role role) {
        return role;
    }
}
