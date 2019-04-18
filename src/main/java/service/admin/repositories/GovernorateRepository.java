package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.location.Governorate;

@Repository
public interface GovernorateRepository extends NaturalRepository<Governorate, Integer>, JpaSpecificationExecutor<Governorate> {



}