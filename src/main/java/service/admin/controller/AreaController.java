package service.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.admin.dto.AreaDTO;
import service.admin.model.location.Area;
import service.admin.repositories.AreaRepository;
import service.admin.services.AreaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/area")
public class AreaController  extends EntityControllerCRUD<Area, AreaDTO> {

    @Autowired
    private AreaService areaService;

    @Autowired
    private AreaRepository areaRepository;


    @Override
    public Area buildEntity() {
        return new Area();
    }

    @Override
    public AreaDTO buildDTO() {
        return new AreaDTO();
    }
}
