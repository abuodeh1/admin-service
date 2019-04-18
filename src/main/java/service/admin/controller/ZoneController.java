package service.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.admin.dto.ZoneDTO;
import service.admin.model.location.Zone;
import service.admin.repositories.ZoneRepository;
import service.admin.services.EntityServicePhase;
import service.admin.services.ZoneService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/zone")
public class ZoneController extends EntityControllerCRUD<Zone, ZoneDTO>  implements EntityServicePhase<Zone> {


    @Autowired
    private ZoneService zoneService;

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public Zone buildEntity() {
        return new Zone();
    }

    @Override
    public ZoneDTO buildDTO() {
        return new ZoneDTO();
    }

    @Override
    public Zone beforeSave(Zone entity) {
        return entity;
    }
}
