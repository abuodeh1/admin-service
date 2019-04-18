package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.location.Municipality;
import service.admin.repositories.MunicipalityRepository;
import service.admin.repositories.NaturalRepository;

@Service
public class MunicipalityService  extends AbstractEntityService<Municipality>  {

    @Autowired
    private MunicipalityRepository municipalityRepository;

    public MunicipalityRepository getMunicipalityRepository() {
        return municipalityRepository;
    }



    public void setMunicipalityRepository(MunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }

    @Override
    public NaturalRepository getRepository() {
        return municipalityRepository;
    }
}
