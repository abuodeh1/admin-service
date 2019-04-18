package service.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.admin.dto.MunicipalityDTO;
import service.admin.model.location.Municipality;
import service.admin.repositories.MunicipalityRepository;
import service.admin.services.MunicipalityService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/municipality")
public class MunicipalityController extends EntityControllerCRUD<Municipality, MunicipalityDTO>{


    @Autowired
    private MunicipalityService municipalityService;

    @Autowired
    private MunicipalityRepository municipalityRepository;



    @Override
    public Municipality buildEntity() {
        return new Municipality();
    }

    @Override
    public MunicipalityDTO buildDTO() {
        return new MunicipalityDTO();
    }
}
