package service.admin.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.location.GovernorateMunicipality;
import service.admin.model.location.GovernorateMunicipalityIdentity;
import service.admin.model.location.Municipality;

import java.util.List;

@Repository
public interface GovernorateMunicipalityRepository extends NaturalRepository<GovernorateMunicipality, GovernorateMunicipalityIdentity> {


    @Query
    List<Municipality> getGovernorateMunicipalityByGovernorateCode(String code);
}

