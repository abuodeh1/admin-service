package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.controller.find.QuerySpecification;
import service.admin.model.lookup.Lookup;
import service.admin.repositories.LookupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LookupService {

    @Autowired
    private LookupRepository lookupRepository;


    public LookupRepository getRepository() {
        return lookupRepository;
    }

    public Lookup save(Lookup lookup){

        return  lookupRepository.save(lookup);
    }

    public Optional<Lookup> get(String code){

        Optional<Lookup> lookup1 = lookupRepository.findById(code);
        return  lookup1;
    }

    public boolean delete(String code){

        Optional<Lookup> lookup = getRepository().findById(code);

        if (lookup.isPresent()) {

            lookupRepository.delete(lookup.get());

            return true;
        }

        return false;

    }




    public List<Lookup> getAll(){

        return getRepository().findAll();
    }

    public List<Lookup> find(QuerySpecification<Lookup> querySpecification){

        return lookupRepository.findAll(querySpecification);
    }




    public List<Lookup> getLookupChilds(String parent) {

        return lookupRepository.getLookupChilds(parent);
    }

    public List<Lookup> getAllParentLookup() {

        return  lookupRepository.getAllParentsLookup();
    }

    public Lookup getParentLookup(String code) {
        return lookupRepository.getParentLookup(code);
    }

    public List<Lookup> getAllChildLookup() {
        return lookupRepository.getAllChildLookup();
    }



}
