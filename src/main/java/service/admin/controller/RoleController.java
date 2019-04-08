package service.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.admin.dto.RoleDTO;
import service.admin.model.role.Role;
import service.admin.services.RoleService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/role")
public class RoleController extends EntityControllerCRUD<Role, RoleDTO> {

    @Autowired
    private RoleService roleService;


    @Override
    public Role buildEntity() {
        return new Role();
    }

    @Override
    public RoleDTO buildDTO() {
        return new RoleDTO();
    }
}
