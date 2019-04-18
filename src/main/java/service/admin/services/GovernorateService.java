package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.location.Governorate;
import service.admin.repositories.GovernorateRepository;
import service.admin.repositories.NaturalRepository;


@Service
public class GovernorateService extends AbstractEntityService<Governorate> implements EntityServicePhase<Governorate> {
    @Autowired
    private GovernorateRepository governorateRepository;


    @Override
    public NaturalRepository getRepository() {
        return governorateRepository;
    }

    @Override
    public Governorate beforeSave(Governorate governorate) {
        return governorate;
    }


    public GovernorateRepository getGovernorateRepository() {
        return governorateRepository;
    }

    public void setGovernorateRepository(GovernorateRepository governorateRepository) {
        this.governorateRepository = governorateRepository;
    }
}
