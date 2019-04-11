package service.admin.services;

import service.admin.controller.find.QuerySpecification;
import service.admin.repositories.NaturalRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractEntityService<BaseDomain> {

    public Optional<BaseDomain> get(String code){
        return getRepository().findBySimpleNaturalId(code);
    }

    public BaseDomain save(BaseDomain baseDomain){

        baseDomain = beforeSave(baseDomain);

        return (BaseDomain) getRepository().save(baseDomain);
    }

    public boolean delete(String code){

        Optional<BaseDomain> entity = getRepository().findBySimpleNaturalId(code);

        if (entity.isPresent()) {

            getRepository().delete(entity);

            return true;
        }

        return false;

    }

    public List<BaseDomain> getAll(){

        return getRepository().findAll();
    }

    public List<BaseDomain> find(QuerySpecification<BaseDomain> querySpecification){

        return getRepository().findAll(querySpecification);
    }

    public abstract NaturalRepository getRepository();

    public abstract BaseDomain beforeSave(BaseDomain baseDomain);
}
