package service.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.admin.dto.GroupDTO;
import service.admin.model.group.Group;
import service.admin.services.GroupService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/group")
public class GroupController extends EntityControllerCRUD<Group, GroupDTO> {

    @Autowired
    GroupService groupService;

    @Override
    public Group buildEntity() {
        return new Group();
    }

    @Override
    public GroupDTO buildDTO() {
        return new GroupDTO();
    }
}
