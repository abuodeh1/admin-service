package service.admin.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.dto.AreaDTO;
import service.admin.dto.GovernorateDTO;
import service.admin.model.location.Areas;
import service.admin.model.location.Governorates;
import service.admin.repositories.AreaRepository;
import service.admin.services.AreaService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/area")
public class AreaController  extends EntityControllerCRUD<Areas, AreaDTO> {

    @Autowired
    private AreaService areaService;

    @Autowired
    private AreaRepository areaRepository;


    @GetMapping("/{code}/governorate")
    @ResponseBody
    public List<GovernorateDTO> getAreaGovernorateByAreaCode(@PathVariable String code) {

        List<Governorates> areaList = areaService.getAreaGovernorateByAreaCode(code);

        List<GovernorateDTO> dtos = new ArrayList<>();

        areaList.parallelStream().forEach(entity -> {
            GovernorateDTO dto = new GovernorateDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }


    @Override
    public Areas buildEntity() {
        return new Areas();
    }

    @Override
    public AreaDTO buildDTO() {
        return new AreaDTO();
    }
}
