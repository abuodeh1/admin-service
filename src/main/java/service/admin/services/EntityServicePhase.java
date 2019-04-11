package service.admin.services;

public interface EntityServicePhase<BaseDomain> {

    void beforeSave(BaseDomain entity);

}
