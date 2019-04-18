package service.admin.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.admin.dto.GovernorateDTO;
import service.admin.dto.MunicipalityDTO;
import service.admin.model.location.Governorates;
import service.admin.model.location.Municipality;
import service.admin.services.GovernorateService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/governorate")
public class GovernorateController extends EntityControllerCRUD<Governorates, GovernorateDTO>  {

    @Autowired
    private GovernorateService governorateService;


    @GetMapping("/{code}/governorate")
    @ResponseBody
    public List<MunicipalityDTO> getGovernorateMunicipalityByGovernorateCode(@PathVariable String code) {

        List<Municipality> municipalityList = governorateService.getGovernorateMunicipalityByGovernorateCode(code);

        List<MunicipalityDTO> dtos = new ArrayList<>();

        municipalityList.parallelStream().forEach(entity -> {
            MunicipalityDTO dto = new MunicipalityDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    @Override
    public Governorates buildEntity() {
        return new Governorates();
    }

    @Override
    public GovernorateDTO buildDTO() {
        return new GovernorateDTO();
    }

}




