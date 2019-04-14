package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.privilege.Privilege;

@Repository
public interface PrivilegeRepository extends NaturalRepository<Privilege, Integer>, JpaSpecificationExecutor<Privilege> {

}