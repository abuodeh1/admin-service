package service.admin.services;

import service.admin.model.user.User;

public interface EntityServicePhase<BaseDomain> {

    User beforeSave(BaseDomain entity);

}
