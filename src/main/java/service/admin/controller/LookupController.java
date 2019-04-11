package service.admin.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.admin.controller.find.QuerySpecification;
import service.admin.controller.find.SearchCriteria;
import service.admin.dto.LookupDTO;
import service.admin.model.lookup.Lookup;
import service.admin.services.LookupService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
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

        return new ResponseEntity(lookupService.getLookupChilds(parent), HttpStatus.OK);
    }

//    @GetMapping(value = "/{lookupID}/{parent}")
//    public List<Lookup> getChildLookup(@PathVariable String lookupID,@PathVariable String parent) {
//        return lookupService.getChildLookup(lookupID,parent);
//    }

//    @GetMapping(value = "/{parentID}/{lookupID}/attach")
//    public void attachChildLookup(@PathVariable String parentID,@PathVariable String lookupID) {
//       lookupService.attachChildLookup(parentID,lookupID);
//    }

    @PostMapping( value = "/findParent")
    public ResponseEntity<List<Lookup>> findParent(@RequestBody List<SearchCriteria> criteriaList) {
    //to do
        QuerySpecification<Lookup> querySpecification = new QuerySpecification(criteriaList);
        List<Lookup> parentLookup = new ArrayList<>();
        List<Lookup> entitie = baseService.find(querySpecification);
        for ( int i=0 ;i<entitie.size();i++){
            if(entitie.get(i).getParent().equalsIgnoreCase("0")){

                parentLookup.add(entitie.get(0));
            }
        }
        List<LookupDTO> dtos = new ArrayList<>();

        parentLookup.stream().forEach( entity -> {
            LookupDTO dto = buildDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    @PostMapping( value = "/findChild")
    public ResponseEntity<List<Lookup>> findChild(@RequestBody List<SearchCriteria> criteriaList) {
    //to do
        QuerySpecification<Lookup> querySpecification = new QuerySpecification(criteriaList);
        List<Lookup> childLookup = new ArrayList<>();
        List<Lookup> entitie = baseService.find(querySpecification);
        for ( int i=0 ;i<entitie.size();i++){
            if(!entitie.get(i).getParent().equalsIgnoreCase("0")){

                childLookup.add(entitie.get(0));
            }
        }
        List<LookupDTO> dtos = new ArrayList<>();

        childLookup.stream().forEach( entity -> {
            LookupDTO dto = buildDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    @GetMapping( value = "/allchild")
    public ResponseEntity<List<Lookup>> gelAllChild() {
        List<Lookup> entitie = lookupService.getAllChildLookup();

        List<LookupDTO> dtos = new ArrayList<>();

        entitie.stream().forEach( entity -> {
            LookupDTO dto = buildDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return new ResponseEntity(dtos, HttpStatus.OK);
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
