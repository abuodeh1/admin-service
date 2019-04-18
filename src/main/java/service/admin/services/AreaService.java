package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.location.Area;
import service.admin.repositories.AreaRepository;

@Service
public class AreaService extends AbstractEntityService<Area> implements EntityServicePhase<Area>{

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public AreaRepository getRepository() {
        return areaRepository;
    }

    @Override
    public Area beforeSave(Area area) {
        return area;
    }
}
