package service.admin.services;

import service.admin.controller.find.QuerySpecification;
import service.admin.repositories.NaturalRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractEntityService<T> {

    public Optional<T> get(String code){
        return getRepository().findBySimpleNaturalId(code);
    }

    public T save(T entity){

        if(getRepository() instanceof EntityServicePhase) {

            entity = (T)((EntityServicePhase) getRepository()).beforeSave(entity);
        }

        return (T) getRepository().save(entity);
    }

    public boolean delete(String code){

        Optional<T> entity = getRepository().findBySimpleNaturalId(code);

        if (entity.isPresent()) {

            getRepository().delete(entity);

            return true;
        }

        return false;

    }

    public List<T> getAll(){

        return getRepository().findAll();
    }

    public List<T> find(QuerySpecification<T> querySpecification){

        return getRepository().findAll(querySpecification);
    }

    public abstract NaturalRepository getRepository();

//    public abstract T beforeSave(T baseDomain);
}
