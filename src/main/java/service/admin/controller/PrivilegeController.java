package service.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.admin.dto.PrivilegeDTO;
import service.admin.model.privilege.Privilege;
import service.admin.services.PrivilegeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/privilege")
public class PrivilegeController extends EntityControllerCRUD<Privilege, PrivilegeDTO> {

    @Autowired
    private PrivilegeService privilegeService;

    @Override
    public Privilege buildEntity() {
        return new Privilege();
    }

    @Override
    public PrivilegeDTO buildDTO() {
        return new PrivilegeDTO();
    }
}

