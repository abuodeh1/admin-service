package service.admin.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.admin.dto.PrivilegeDTO;
import service.admin.dto.RoleDTO;
import service.admin.dto.UserDTO;
import service.admin.model.privilege.Privilege;
import service.admin.model.role.Role;
import service.admin.model.user.User;
import service.admin.services.UserService;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/user")
public class UserController extends EntityControllerCRUD<User, UserDTO>  {

    @Autowired
    private UserService userService;

    @GetMapping("/{code}/privileges")
    public ResponseEntity<PrivilegeDTO> getUserPrivilegesByUserCode(@PathVariable String code){

        List<Privilege> privilegeList=  userService.getUserPrivilegesByUserCode(code);

        List<PrivilegeDTO> dtos = new ArrayList<>();

        privilegeList.stream().forEach( entity -> {
            PrivilegeDTO dto = new PrivilegeDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    @GetMapping("/{code}/roles")
    public ResponseEntity<RoleDTO> getUserRolesByUserCode(@PathVariable String code){

        List<Role> roleList=  userService.getUserRolesByUserCode(code);

            List<RoleDTO> dtos = new ArrayList<>();

        roleList.stream().forEach( entity -> {
                RoleDTO dto = new RoleDTO();
                BeanUtils.copyProperties(entity, dto);
                dtos.add(dto);
            });

            return new ResponseEntity(dtos, HttpStatus.OK);
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

