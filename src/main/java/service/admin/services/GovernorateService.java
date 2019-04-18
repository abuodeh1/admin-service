package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.location.Governorates;
import service.admin.model.location.Municipality;
import service.admin.repositories.GovernorateMunicipalityRepository;
import service.admin.repositories.GovernorateRepository;
import service.admin.repositories.NaturalRepository;

import java.util.List;


@Service
public class GovernorateService extends AbstractEntityService<Governorates> {

    @Autowired
    private GovernorateRepository governorateRepository;
    @Autowired
    GovernorateMunicipalityRepository governorateMunicipalityRepository;

    @Override
    public NaturalRepository getRepository() {
        return governorateRepository;
    }

    public List<Municipality> getGovernorateMunicipalityByGovernorateCode(String code) {
        return governorateMunicipalityRepository.getGovernorateMunicipalityByGovernorateCode(code);


    }
}
