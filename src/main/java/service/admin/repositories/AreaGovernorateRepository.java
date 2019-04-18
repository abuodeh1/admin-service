package service.admin.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.location.AreaGovernorate;
import service.admin.model.location.AreaGovernorateIdentity;
import service.admin.model.location.Governorates;

import java.util.List;

@Repository
public interface AreaGovernorateRepository extends NaturalRepository<AreaGovernorate, AreaGovernorateIdentity> {

    @Query
    List<Governorates> getAreaGovernorateByAreaCode(String code);


    }

