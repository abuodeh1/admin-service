package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.role.Role;
import service.admin.model.user.UserRoles;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, String> , JpaSpecificationExecutor<UserRoles> {


    @Query
    List<Role> getUserRolesByUserCode(String code);
}