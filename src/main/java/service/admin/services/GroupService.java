package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.group.Group;
import service.admin.repositories.GroupRepository;

@Service
public class GroupService extends AbstractEntityService<Group> {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public GroupRepository getRepository() {
        return groupRepository;
    }

    @Override
    public Group beforeSave(Group group) {
        return group;
    }

}

