package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.privilege.Privilege;
import service.admin.model.user.UserPrivileges;
import service.admin.model.user.UserPrivilegesIdentity;

import java.util.List;

@Repository
public interface UserPrivilegesRepository extends JpaRepository<UserPrivileges, UserPrivilegesIdentity> {

    @Query
    List<Privilege> getUserPrivilegesByUserCode(String code);

}
