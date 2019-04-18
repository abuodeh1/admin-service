package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.location.Zones;

@Repository
public interface ZoneRepository extends NaturalRepository<Zones, Integer>, JpaSpecificationExecutor<Zones> {

}