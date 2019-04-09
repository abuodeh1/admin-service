package service.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @GetMapping(value = "/parent")
    public ResponseEntity<List<Lookup>> getAllParentLookup() {

        return new ResponseEntity(lookupService.getAllParentLookup(), HttpStatus.OK);
    }

    @GetMapping(value = "/parent/{code}")
    public ResponseEntity<Lookup> getParentLookup(@PathVariable  String code) {

        return new ResponseEntity(lookupService.getParentLookup(code), HttpStatus.OK);
    }

    @GetMapping(value = "/parent/{parent}/child")
    public ResponseEntity<List<Lookup>> getAllChildsLookup(@PathVariable String parent) {

        return new ResponseEntity(lookupService.getAllChildsLookup(parent), HttpStatus.OK);
    }

//    @GetMapping(value = "/{lookupID}/{parent}")
//    public List<Lookup> getChildLookup(@PathVariable String lookupID,@PathVariable String parent) {
//        return lookupService.getChildLookup(lookupID,parent);
//    }

//    @GetMapping(value = "/{parentID}/{lookupID}/attach")
//    public void attachChildLookup(@PathVariable String parentID,@PathVariable String lookupID) {
//       lookupService.attachChildLookup(parentID,lookupID);
//    }

    @Override
    public Lookup buildEntity() {
        return new Lookup();
    }

    @Override
    public LookupDTO buildDTO() {
        return new LookupDTO();
    }
}
