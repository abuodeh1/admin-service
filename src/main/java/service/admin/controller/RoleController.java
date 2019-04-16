package service.admin.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.dto.PrivilegeDTO;
import service.admin.dto.RoleDTO;
import service.admin.model.privilege.Privilege;
import service.admin.model.role.Role;
import service.admin.model.role.RolePrivilegeIdentity;
import service.admin.model.role.RolePrivileges;
import service.admin.repositories.RolePrivilegesRepository;
import service.admin.services.RoleService;
import service.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/role")
public class RoleController extends EntityControllerCRUD<Role, RoleDTO> {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePrivilegesRepository rolePrivilegesRepository;



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

    @PostMapping("/{code}/privilege")
    @ResponseBody
    public void addPrivilegesToRole(@PathVariable String code, @RequestBody List<PrivilegeDTO> privilegeDTOs) {

        Optional<Role> role = roleService.get(code);

        if(role.isPresent()) {
            List entities = new ArrayList();

            privilegeDTOs.parallelStream().forEach(privilegeDTO ->
                    entities.add(new RolePrivileges(new RolePrivilegeIdentity(role.get().getId(), privilegeDTO.getId())))
            );

            rolePrivilegesRepository.saveAll(entities);
        }else{

            throw new NotFoundException("The role not found");

        }
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
