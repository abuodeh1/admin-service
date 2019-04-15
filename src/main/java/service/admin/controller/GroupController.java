package service.admin.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.admin.dto.GroupDTO;
import service.admin.dto.PrivilegeDTO;
import service.admin.dto.RoleDTO;
import service.admin.dto.UserDTO;
import service.admin.model.group.Group;
import service.admin.model.privilege.Privilege;
import service.admin.model.role.Role;
import service.admin.model.user.User;
import service.admin.repositories.GroupUsersRepository;
import service.admin.services.GroupService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/group")
public class GroupController extends EntityControllerCRUD<Group, GroupDTO> {

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupUsersRepository groupUsersRepository;

//    @GetMapping("/{code}/user")
//    public List<User> getGroupUsers(@PathVariable String code){
//
//        Optional<Group> group = groupService.get(code);
//        List<User> groupUsers = groupUsersRepository.findByUsers(1);
//        List<User> users = null;
//
//        return users;
//    }

    @GetMapping("/{code}/privileges")
    public ResponseEntity<PrivilegeDTO> getGroupPrivilegesByGroupCode(@PathVariable String code){

        List<Privilege> privilegeList=  groupService.getGroupPrivilegesByGroupCode(code);

        List<PrivilegeDTO> dtos = new ArrayList<>();

        privilegeList.stream().forEach( entity -> {
            PrivilegeDTO dto = new PrivilegeDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    @GetMapping("/{code}/roles")
    public ResponseEntity<RoleDTO> getGroupRolesByGroupCode(@PathVariable String code){

        List<Role> roleList=  groupService.getGroupRolesByGroupCode(code);

        List<RoleDTO> dtos = new ArrayList<>();

        roleList.stream().forEach( entity -> {
            RoleDTO dto = new RoleDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    @GetMapping("/{code}/users")
    public ResponseEntity<RoleDTO> getGroupUsersByGroupCode(@PathVariable String code){

        List<User> userList=  groupService.getGroupUsersByGroupCode(code);

        List<UserDTO> dtos = new ArrayList<>();

        userList.stream().forEach( entity -> {
            UserDTO dto = new UserDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    @Override
    public Group buildEntity() {
        return new Group();
    }

    @Override
    public GroupDTO buildDTO() {
        return new GroupDTO();
    }

}
