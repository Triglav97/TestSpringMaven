package com.triglav.TestSpringMaven.controller;

import com.triglav.TestSpringMaven.dto.PhoneEntity;
import com.triglav.TestSpringMaven.service.PhonesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
//@RequestMapping("/api")
public class PhoneBookController{

    private final PhonesService phonesService;

    @Autowired
    public PhoneBookController(PhonesService phonesService) {
        this.phonesService = phonesService;
    }

    @PostMapping(value = "/phonebook")
    public ResponseEntity<?> create(@RequestBody PhoneEntity phoneEntity) throws Exception{
        return phonesService.create(phoneEntity)
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/phonebook")
    public ResponseEntity<List<PhoneEntity>> read(){
        final List<PhoneEntity> phoneEntity = phonesService.readAll();

        return phoneEntity != null && !phoneEntity.isEmpty()
                ? new ResponseEntity<>(phoneEntity, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/phonebook/{id}")
    public ResponseEntity<PhoneEntity> read(@PathVariable(name = "id") long id){
        final PhoneEntity phoneEntity = phonesService.read(id);

        return phoneEntity != null
                ? new ResponseEntity<>(phoneEntity, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/phonebook/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody PhoneEntity phoneEntity){
        final boolean updated = phonesService.update(phoneEntity, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/phonebook/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        final boolean deleted = phonesService.delete(id);

        return  deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
