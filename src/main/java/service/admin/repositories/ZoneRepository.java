package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.location.Zone;

@Repository
public interface ZoneRepository extends NaturalRepository<Zone, Integer>, JpaSpecificationExecutor<Zone> {

}