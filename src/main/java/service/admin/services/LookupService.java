package service.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.admin.model.lookup.Lookup;
import service.admin.repositories.LookupRepository;

import java.util.List;

@Service
public class LookupService extends AbstractEntityService<Lookup> {

    @Autowired
    private LookupRepository lookupRepository;

    @Override
    public LookupRepository getRepository() {
        return lookupRepository;
    }

    public List<Lookup> getAllChildesLookup(String parent) {

        return lookupRepository.getAllChildesLookup(parent);
    }

    public List<Lookup> getAllParentLookup() {

        return  lookupRepository.getAllParentsLookup();
    }

    public Lookup getParentLookup(String code) {
        return lookupRepository.getParentLookup(code);
    }

}
