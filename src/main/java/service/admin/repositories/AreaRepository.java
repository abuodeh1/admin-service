package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.location.Area;

@Repository
public interface AreaRepository extends NaturalRepository<Area, Integer>, JpaSpecificationExecutor<Area> {

}