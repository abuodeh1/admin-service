package service.admin.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.privilege.Privilege;
import service.admin.model.role.RolePrivilegeIdentity;
import service.admin.model.role.RolePrivileges;

import java.util.List;

@Repository
public interface RolePrivilegesRepository extends NaturalRepository<RolePrivileges, RolePrivilegeIdentity> {

    @Query
    List<Privilege> getRolePrivilegesByRoleCode (String code);


    }

