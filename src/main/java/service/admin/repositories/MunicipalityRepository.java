package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.location.Municipality;

@Repository
public interface MunicipalityRepository extends NaturalRepository<Municipality, Integer>, JpaSpecificationExecutor<Municipality> {

}