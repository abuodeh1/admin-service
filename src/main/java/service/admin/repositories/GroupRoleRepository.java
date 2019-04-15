package service.admin.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.group.GroupRoleIdentity;
import service.admin.model.group.GroupRoles;
import service.admin.model.role.Role;

import java.util.List;

@Repository
public interface GroupRoleRepository extends NaturalRepository <GroupRoles, GroupRoleIdentity>  {


    @Query
    List<Role> getGroupRolesByGroupCode(String code);

        }
