package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.location.Areas;
import service.admin.model.location.Governorates;
import service.admin.repositories.AreaGovernorateRepository;
import service.admin.repositories.AreaRepository;

import java.util.List;


@Service
public class AreaService extends AbstractEntityService<Areas> {

    @Autowired
    private AreaRepository areaRepository;



    @Autowired
    AreaGovernorateRepository areaGovernorateRepository ;

    @Override
    public AreaRepository getRepository() {
        return areaRepository;
    }



    public List<Governorates> getAreaGovernorateByAreaCode(String code) {

        return areaGovernorateRepository.getAreaGovernorateByAreaCode(code);
    }

}
