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
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/admin/lookup")
public class LookupController {

    @Autowired
    private LookupService lookupService;

    @PostMapping(value = {"", "/"})
    @ResponseBody
    public LookupDTO add(@RequestBody LookupDTO dto) {

        Lookup newEntity = buildEntity();

        BeanUtils.copyProperties(dto, newEntity);

        Lookup addedUser = lookupService.save(newEntity);

        BeanUtils.copyProperties(addedUser, dto,"id");

        return dto;
    }

    @GetMapping(value = "/{code}")
    @ResponseBody
    public LookupDTO get(@PathVariable String code) {

        Optional<Lookup> entity = lookupService.get(code);

        LookupDTO dto = buildDTO();

        if(entity.isPresent()){

            BeanUtils.copyProperties(entity.get(), dto);
        }

        return dto;
    }

    @DeleteMapping(value = "/{code}")
    @ResponseBody
    public void delete(@PathVariable String code) {

        Optional<Lookup> lookup =lookupService.get(code);

        if(lookup.isPresent()){

            lookupService.delete(code);

        }
    }

    @PutMapping
    @ResponseBody
    public LookupDTO update(@RequestBody LookupDTO dto) {

        Optional<Lookup> entity = lookupService.get(dto.getCode());

        if(entity.isPresent()) {

            Lookup newEntity = buildEntity();

            BeanUtils.copyProperties(dto, newEntity);

            newEntity.setCode(entity.get().getCode());

            Lookup updatedLookup = lookupService.save(newEntity);

            BeanUtils.copyProperties(updatedLookup, dto);
        }

        return dto;

    }

    @GetMapping({"", "/"})
    @ResponseBody
    public List<LookupDTO> getAll() {

        List<Lookup> entities = lookupService.getAll();

        List<LookupDTO> dtos = new ArrayList<>();

        entities.stream().forEach( entity -> {
            LookupDTO dto = buildDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }

    @PostMapping( value = "/find")
    @ResponseBody
    public List<LookupDTO> find(@RequestBody List<SearchCriteria> criteriaList) {

        QuerySpecification<Lookup> querySpecification = new QuerySpecification(criteriaList);

        List<Lookup> entities = lookupService.find(querySpecification);

        List<LookupDTO> dtos = new ArrayList<>();

        entities.stream().forEach( entity -> {
            LookupDTO dto = buildDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        });

        return dtos;
    }


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
//
//    @GetMapping(value = "/{lookupID}/{parent}")
//    public List<Lookup> getChildLookup(@PathVariable String lookupID,@PathVariable String parent) {
//        return lookupService.getChildLookup(lookupID,parent);
//    }

//    @GetMapping(value = "/{parentID}/{lookupID}/attach")
//    public void attachChildLookup(@PathVariable String parentID,@PathVariable String lookupID) {
//       lookupService.attachChildLookup(parentID,lookupID);
//    }

//    @PostMapping( value = "/findParent")
//    public ResponseEntity<List<Lookup>> findParent(@RequestBody List<SearchCriteria> criteriaList) {
//    //to do
//        QuerySpecification<Lookup> querySpecification = new QuerySpecification(criteriaList);
//        List<Lookup> parentLookup = new ArrayList<>();
//        List<Lookup> entitie = baseService.find(querySpecification);
//        for ( int i=0 ;i<entitie.size();i++){
//            if(entitie.get(i).getParent().equalsIgnoreCase("0")){
//
//                parentLookup.add(entitie.get(0));
//            }
//        }
//        List<LookupDTO> dtos = new ArrayList<>();
//
//        parentLookup.stream().forEach( entity -> {
//            LookupDTO dto = buildDTO();
//            BeanUtils.copyProperties(entity, dto);
//            dtos.add(dto);
//        });
//
//        return new ResponseEntity(dtos, HttpStatus.OK);
//    }
//
//    @PostMapping( value = "/findChild")
//    public ResponseEntity<List<Lookup>> findChild(@RequestBody List<SearchCriteria> criteriaList) {
//    //to do
//        QuerySpecification<Lookup> querySpecification = new QuerySpecification(criteriaList);
//        List<Lookup> childLookup = new ArrayList<>();
//        List<Lookup> entitie = baseService.find(querySpecification);
//        for ( int i=0 ;i<entitie.size();i++){
//            if(!entitie.get(i).getParent().equalsIgnoreCase("0")){
//
//                childLookup.add(entitie.get(0));
//            }
//        }
//        List<LookupDTO> dtos = new ArrayList<>();
//
//        childLookup.stream().forEach( entity -> {
//            LookupDTO dto = buildDTO();
//            BeanUtils.copyProperties(entity, dto);
//            dtos.add(dto);
//        });
//
//        return new ResponseEntity(dtos, HttpStatus.OK);
//    }

//    @GetMapping( value = "/allchild")
//    public ResponseEntity<List<Lookup>> gelAllChild() {
//        List<Lookup> entitie = lookupService.getAllChildLookup();
//
//        List<LookupDTO> dtos = new ArrayList<>();
//
//        entitie.stream().forEach( entity -> {
//            LookupDTO dto = buildDTO();
//            BeanUtils.copyProperties(entity, dto);
//            dtos.add(dto);
//        });
//
//        return new ResponseEntity(dtos, HttpStatus.OK);
//    }


    public Lookup buildEntity() {
        return new Lookup();
    }

    public LookupDTO buildDTO() {
        return new LookupDTO();
    }
}
