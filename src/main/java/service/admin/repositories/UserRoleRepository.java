package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.user.UserRoles;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles, String> , JpaSpecificationExecutor<UserRoles> {


}