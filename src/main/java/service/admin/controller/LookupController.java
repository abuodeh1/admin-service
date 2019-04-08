package service.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.admin.dto.LookupDTO;
import service.admin.model.lookup.Lookup;
import service.admin.services.LookupService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/lookup")
public class LookupController extends EntityControllerCRUD<Lookup, LookupDTO> {

    @Autowired
    private LookupService lookupService;

//    @GetMapping(value = "/{roleID}/deactive")
//    public Lookup deactiveRole(@PathVariable String lookupID) {
//        return lookupService.disableLookup(lookupID);
//    }

    @GetMapping(value = "/lookupID/parent")
    public String getParentLookup(@PathVariable String lookupID) {
        return lookupService.getParentLookup(lookupID);
    }

    @GetMapping(value = "/AllParent")
    public List<Lookup> getAllParentLookup() {
        return lookupService.getAllParentLookup();
    }

    @GetMapping(value = "/{lookupID}/AllChilds")
    public List<Lookup> getAllChildsLookup(@PathVariable String lookupID) {
        return lookupService.GetAllChildsLookup(lookupID);
    }

    @GetMapping(value = "/{lookupID}/{parent}")
    public List<Lookup> getChildLookup(@PathVariable String lookupID,@PathVariable String parent) {
        return lookupService.GetChildLookup(lookupID,parent);
    }

    @GetMapping(value = "attach/{parentID}/{lookupID}")
    public void attachChildLookup(@PathVariable String parentID,@PathVariable String lookupID) {
       lookupService.attachChildLookup(parentID,lookupID);
    }


    @Override
    public Lookup buildEntity() {
        return new Lookup();
    }

    @Override
    public LookupDTO buildDTO() {
        return new LookupDTO();
    }
}
