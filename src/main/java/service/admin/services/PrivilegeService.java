package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.privilege.Privilege;
import service.admin.repositories.PrivilegeRepository;

@Service
public class PrivilegeService extends AbstractEntityService<Privilege> {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public PrivilegeRepository getRepository() {
        return privilegeRepository;
    }

    @Override
    public Privilege beforeSave(Privilege privilege) {
        return privilege;
    }
}
