package service.admin.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.dto.PrivilegeDTO;
import service.admin.dto.RoleDTO;
import service.admin.model.privilege.Privilege;
import service.admin.model.role.Role;
import service.admin.services.RoleService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/role")
public class RoleController extends EntityControllerCRUD<Role, RoleDTO> {

    @Autowired
    private RoleService roleService;



    @GetMapping("/{code}/privileges")
    @ResponseBody
    public List<PrivilegeDTO> getUserPrivilegesByUserCode(@PathVariable String code){

        List<Privilege> privilegeList=  roleService.getRolePrivilegesByRoleCode(code);

        List<PrivilegeDTO> dtos = new ArrayList<>();

        privilegeList.stream().forEach( entity -> {
            PrivilegeDTO dto = new PrivilegeDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    @Override
    public Role buildEntity() {
        return new Role();
    }

    @Override
    public RoleDTO buildDTO() {
        return new RoleDTO();
    }
}
