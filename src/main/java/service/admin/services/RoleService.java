package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.privilege.Privilege;
import service.admin.model.role.Role;
import service.admin.repositories.RolePrivilegesRepository;
import service.admin.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleService extends AbstractEntityService<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePrivilegesRepository rolePrivilegesRepository;


    public  List<Privilege> getRolePrivilegesByRoleCode(String code) {
        return rolePrivilegesRepository.getRolePrivilegesByRoleCode(code);
    }



    @Override
    public RoleRepository getRepository() {
        return roleRepository;
    }

}
