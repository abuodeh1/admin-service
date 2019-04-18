package service.admin.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.dto.PrivilegeDTO;
import service.admin.dto.RoleDTO;
import service.admin.dto.UserDTO;
import service.admin.model.privilege.Privilege;
import service.admin.model.role.Role;
import service.admin.model.user.*;
import service.admin.repositories.UserPrivilegesRepository;
import service.admin.repositories.UserRoleRepository;
import service.admin.services.UserRoleService;
import service.admin.services.UserService;
import service.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/user")
public class UserController extends EntityControllerCRUD<User, UserDTO> {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserPrivilegesRepository userPrivilegesRepository;
    @Autowired
   private UserRoleRepository userRolesRepository;


    @GetMapping("/{code}/privileges")
    @ResponseBody
    public  List<PrivilegeDTO> getUserPrivilegesByUserCode(@PathVariable String code) {

        List<Privilege> privilegeList = userService.getUserPrivilegesByUserCode(code);

        List<PrivilegeDTO> dtos = new ArrayList<>();

        privilegeList.stream().forEach(entity -> {
            PrivilegeDTO dto = new PrivilegeDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    @GetMapping("/{code}/roles")
    @ResponseBody
    public List<RoleDTO> getUserRolesByUserCode(@PathVariable String code) {

        List<Role> roleList = userService.getUserRolesByUserCode(code);

        List<RoleDTO> dtos = new ArrayList<>();

        roleList.parallelStream().forEach(entity -> {
            RoleDTO dto = new RoleDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    @PostMapping("/{code}/privilege")
    @ResponseBody
    public void addPrivilegesToUser(@PathVariable String code, @RequestBody List<PrivilegeDTO> privilegeDTOs) {

        Optional<User> user = userService.get(code);

        if(user.isPresent()) {
            List entities = new ArrayList();

            privilegeDTOs.parallelStream().forEach(privilegeDTO ->
                    entities.add(new UserPrivileges(new UserPrivilegesIdentity(user.get().getId(), privilegeDTO.getId())))
            );
            userPrivilegesRepository.saveAll(entities);
        }else{
            throw new NotFoundException("The user not found");
        }
    }

    @PostMapping("/{code}/Roles")
    @ResponseBody
    public void addRolesToUser(@PathVariable String code, @RequestBody List<RoleDTO> roleDTOs) {

        Optional<User> user = userService.get(code);

        if(user.isPresent()) {
            List entities = new ArrayList();

            roleDTOs.parallelStream().forEach(roleDTO ->
                    entities.add(new UserRoles(new UserRoleIdentity(user.get().getId(), roleDTO.getId())))
            );
            userRolesRepository.saveAll(entities);
        }else{
            throw new NotFoundException("The user not found");
        }
    }

    @Override
    public User buildEntity() {
        return new User();
    }

    @Override
    public UserDTO buildDTO() {
        return new UserDTO();
    }
}

