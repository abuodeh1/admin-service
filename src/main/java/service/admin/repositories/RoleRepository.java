package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.role.Role;

@Repository
public interface RoleRepository extends NaturalRepository<Role, Integer> , JpaSpecificationExecutor<Role> {

}