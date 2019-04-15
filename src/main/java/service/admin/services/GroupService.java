package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.group.Group;
import service.admin.model.privilege.Privilege;
import service.admin.model.role.Role;
import service.admin.model.user.User;
import service.admin.repositories.GroupPrivilegesRepository;
import service.admin.repositories.GroupRepository;
import service.admin.repositories.GroupRoleRepository;
import service.admin.repositories.GroupUserRepository;

import java.util.List;

@Service
public class GroupService extends AbstractEntityService<Group> implements EntityServicePhase<Group> {

    @Autowired
    private GroupRepository groupRepository;


    @Autowired
    private GroupPrivilegesRepository groupPrivilegesRepository;

    @Autowired
    private GroupRoleRepository groupRoleRepository;

    @Autowired
    private GroupUserRepository groupUserRepository;




    @Autowired
    private GroupRoleRepository userRoleRepository;

    public  List<Role> getGroupRolesByGroupCode(String code) {

        return groupRoleRepository.getGroupRolesByGroupCode(code);
    }


    public List<Privilege> getGroupPrivilegesByGroupCode(String code) {

        return groupPrivilegesRepository.getGroupPrivilegesByGroupCode(code);
    }

    public List<User> getGroupUsersByGroupCode(String code) {
        return groupUserRepository.getGroupUsersByGroupCode(code);
    }

    @Override
    public GroupRepository getRepository() {
        return groupRepository;
    }

    @Override
    public Group beforeSave(Group entity) {
        return null;
    }

    public GroupRepository getGroupRepository() {
        return groupRepository;
    }

    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public GroupPrivilegesRepository getGroupPrivilegesRepository() {
        return groupPrivilegesRepository;
    }

    public void setGroupPrivilegesRepository(GroupPrivilegesRepository groupPrivilegesRepository) {
        this.groupPrivilegesRepository = groupPrivilegesRepository;
    }



}

