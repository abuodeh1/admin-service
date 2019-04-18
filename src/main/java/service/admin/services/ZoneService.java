package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.location.Zone;
import service.admin.repositories.NaturalRepository;
import service.admin.repositories.ZoneRepository;
@Service
public class ZoneService  extends AbstractEntityService<Zone> implements EntityServicePhase<Zone>{


    @Autowired
    private ZoneRepository zoneRepository;



    @Override
    public NaturalRepository getRepository() {
        return zoneRepository;
    }


    @Override
    public Zone beforeSave(Zone zone) {
        return zone;
    }


    public ZoneRepository getZoneRepository() {
        return zoneRepository;
    }

    public void setZoneRepository(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }
}
