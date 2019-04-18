package service.admin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.admin.dto.GovernorateDTO;
import service.admin.model.location.Governorate;
import service.admin.repositories.GovernorateRepository;
import service.admin.services.GovernorateService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/governorate")
public class GovernorateController extends EntityControllerCRUD<Governorate, GovernorateDTO>  {

    @Autowired
    private GovernorateService governorateService;

    @Autowired
    private GovernorateRepository governorateRepository;

    @Override
    public Governorate buildEntity() {
        return new Governorate();
    }

    @Override
    public GovernorateDTO buildDTO() {
        return new GovernorateDTO();
    }
}




