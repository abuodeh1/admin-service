package service.admin.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.dto.AreaDTO;
import service.admin.dto.ZoneDTO;
import service.admin.model.location.Areas;
import service.admin.model.location.Zones;
import service.admin.repositories.ZoneRepository;
import service.admin.services.EntityServicePhase;
import service.admin.services.ZoneService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/zone")
public class ZoneController extends EntityControllerCRUD<Zones, ZoneDTO>  implements EntityServicePhase<Zones> {

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public Zones buildEntity() {
        return new Zones();
    }

    @GetMapping("/{code}/areas")
    @ResponseBody
    public List<AreaDTO> getUserRolesByUserCode(@PathVariable String code) {

        List<Areas> areaList = zoneService.getZoneAreaByZoneCode(code);

        List<AreaDTO> dtos = new ArrayList<>();

        areaList.parallelStream().forEach(entity -> {
            AreaDTO dto = new AreaDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    @Override
    public ZoneDTO buildDTO() {
        return new ZoneDTO();
    }

    @Override
    public Zones beforeSave(Zones entity) {
        return entity;
    }
}
