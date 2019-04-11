package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.controller.find.QuerySpecification;
import service.admin.model.lookup.Lookup;
import service.admin.repositories.LookupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LookupService implements EntityService<Lookup> {

    @Autowired
    private LookupRepository lookupRepository;

    @Override
    public Optional<Lookup> get(String code) {

        return lookupRepository.findLookupByCode(code);
    }

    @Override
    public Lookup save(Lookup lookup) {

        return lookupRepository.save(lookup);
    }

    @Override
    public boolean delete(String code) {

        Optional<Lookup> lookup = get(code);

        if (lookup.isPresent()) {

            lookupRepository.delete(lookup.get());

            return true;
        }

        return false;
    }

    public List<Lookup> getLookupChilds(String parent) {

        return lookupRepository.getLookupChilds(parent);
    }

    public List<Lookup> getAllParentLookup() {

        return  lookupRepository.getAllParentsLookup();
    }

//    public ResponseEntity attachChildLookup(String parent, String id){
//        ResponseEntity responseEntity = null;
//        try {
//            lookupRepository.attachChildLookup(parent, id);
//        }catch (Exception e){
//
//            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
//
//        }
//        return   responseEntity;
//    }

    @Override
    public List<Lookup> getAll() {

        return lookupRepository.findAll();
    }

    @Override
    public List<Lookup> find(QuerySpecification<Lookup> querySpecification) {

        return lookupRepository.findAll(querySpecification);
    }

    public Lookup getParentLookup(String code) {
        return lookupRepository.getParentLookup(code);
    }

    public List<Lookup> getAllChildLookup() {
        return lookupRepository.getAllChildLookup();
    }



}
