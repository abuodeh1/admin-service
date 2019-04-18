package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.location.Areas;
import service.admin.model.location.Zones;
import service.admin.repositories.NaturalRepository;
import service.admin.repositories.ZoneAreaRepository;
import service.admin.repositories.ZoneRepository;

import java.util.List;

@Service
public class ZoneService  extends AbstractEntityService<Zones>{

    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private ZoneAreaRepository zoneAreaRepository;

    @Override
    public NaturalRepository getRepository() {
        return zoneRepository;
    }

    public List<Areas> getZoneAreaByZoneCode(String code) {

        return zoneAreaRepository.getZoneAreaByZoneCode(code);
    }

    public ZoneService() {
    }
}
