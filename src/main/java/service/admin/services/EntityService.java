package service.admin.services;

import service.admin.controller.find.QuerySpecification;

import java.util.List;
import java.util.Optional;

public interface EntityService<BaseDomain> {

    Optional<BaseDomain> get(String code);

    BaseDomain save(BaseDomain baseDomain);

    boolean delete(String code);

    List<BaseDomain> getAll();

    List<BaseDomain> find(QuerySpecification<BaseDomain> querySpecification);
}
