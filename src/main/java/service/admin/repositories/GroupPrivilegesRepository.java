package service.admin.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.group.GroupPrivileges;
import service.admin.model.group.GroupPrivilegesIdentity;
import service.admin.model.privilege.Privilege;

import java.util.List;


@Repository
public interface GroupPrivilegesRepository extends NaturalRepository<GroupPrivileges, GroupPrivilegesIdentity>  {

    @Query
    List<Privilege> getGroupPrivilegesByGroupCode(String code);


    
}
