package service.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.admin.dto.UserDTO;
import service.admin.model.user.User;
import service.admin.services.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/user")
public class UserController extends EntityControllerCRUD<User, UserDTO>  {

    @Autowired
    private UserService userService;

    @Override
    public void modifyDTO(UserDTO dto) {
        dto.setPrivileges(userService.getPriviledgeCodes(dto.getUsername()));
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

