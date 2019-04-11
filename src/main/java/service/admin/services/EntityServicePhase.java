package service.admin.services;

public interface EntityServicePhase<BaseDomain> {

    BaseDomain beforeSave(BaseDomain entity);

}
