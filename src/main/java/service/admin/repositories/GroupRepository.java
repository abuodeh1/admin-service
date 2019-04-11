package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.group.Group;

@Repository
public interface GroupRepository extends NaturalRepository<Group, String>, JpaSpecificationExecutor<Group> {

}