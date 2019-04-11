package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.user.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> , JpaSpecificationExecutor<UserRole> {

}