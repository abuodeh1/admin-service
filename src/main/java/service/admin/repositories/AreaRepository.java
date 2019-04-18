package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.location.Areas;

@Repository
public interface AreaRepository extends NaturalRepository<Areas, Integer>, JpaSpecificationExecutor<Areas> {

}

