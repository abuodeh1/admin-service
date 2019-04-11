package service.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.dto.UserDTO;
import service.admin.model.privilege.Privilege;
import service.admin.model.user.User;
import service.admin.services.UserService;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/user")
public class UserController extends EntityControllerCRUD<User, UserDTO>  {

    @Autowired
    private UserService userService;

    @GetMapping("/{code}/privileges")
    public List<Privilege> getUserPrivilegesByUserCode(@PathVariable String code){

        return userService.getUserPrivilegesByUserCode(code);
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

