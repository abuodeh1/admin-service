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
import service.admin.model.group.*;
import service.admin.model.privilege.Privilege;
import service.admin.model.role.Role;
import service.admin.model.user.User;
import service.admin.repositories.GroupPrivilegesRepository;
import service.admin.repositories.GroupRoleRepository;
import service.admin.repositories.GroupUsersRepository;
import service.admin.services.GroupService;
import service.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/group")
public class GroupController extends EntityControllerCRUD<Group, GroupDTO> {

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupUsersRepository groupUsersRepository;
    @Autowired
    private GroupPrivilegesRepository groupPrivilegesRepository;
    @Autowired
    private GroupRoleRepository groupRolesRepository;


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


    @PostMapping("/{code}/privileges")
    @ResponseBody
    public void addPrivilegesToGroup(@PathVariable String code, @RequestBody List<PrivilegeDTO> privilegeDTOs) {

        Optional<Group> group = groupService.get(code);

        if(group.isPresent()) {
            List entities = new ArrayList();

            privilegeDTOs.parallelStream().forEach(privilegeDTO ->
                    entities.add(new GroupPrivileges(new GroupPrivilegesIdentity(group.get().getId(), privilegeDTO.getId())))
            );

            groupPrivilegesRepository.saveAll(entities);
        }else{

            throw new NotFoundException("The group not found");

        }
    }

    @PostMapping("/{code}/roles")
    @ResponseBody
    public void addRolesToGroup(@PathVariable String code, @RequestBody List<RoleDTO> roleDTOS) {

        Optional<Group> group = groupService.get(code);

        if(group.isPresent()) {
            List entities = new ArrayList();

            roleDTOS.parallelStream().forEach(roleDTO ->
                    entities.add(new GroupRoles(new GroupRoleIdentity(group.get().getId(), roleDTO.getId())))
            );

            groupRolesRepository.saveAll(entities);
        }else{

            throw new NotFoundException("The group not found");

        }
    }

    @PostMapping("/{code}/users")
    @ResponseBody
    public void addUsersToGroup(@PathVariable String code, @RequestBody List<UserDTO> userDTOS) {

        Optional<Group> group = groupService.get(code);

        if(group.isPresent()) {
            List entities = new ArrayList();

            userDTOS.parallelStream().forEach(userDTO ->
                    entities.add(new GroupUsers(new GroupUsersIdentity(group.get().getId(), userDTO.getId())))
            );

            groupUsersRepository.saveAll(entities);
        }else{

            throw new NotFoundException("The group not found");

        }
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
