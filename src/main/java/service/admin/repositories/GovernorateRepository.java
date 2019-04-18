package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.location.Governorates;

@Repository
public interface GovernorateRepository extends NaturalRepository<Governorates, Integer>, JpaSpecificationExecutor<Governorates> {



}