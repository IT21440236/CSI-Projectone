package com.csi.projectone.controller;

import com.csi.projectone.to.PersonTO;
import com.csi.projectone.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping("/persons")
    public ResponseEntity<PersonTO> savePerson(@RequestBody PersonTO personTO) {
        PersonTO savedPerson = personService.savePerson(personTO);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }


    @GetMapping("/persons")
    public ResponseEntity<List<PersonTO>> getPerson() {
        List<PersonTO> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonTO> getPersonById(@PathVariable int id) {
        Optional<PersonTO> person = personService.getSinglePerson(id);

        if (person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PutMapping("/persons")
    public ResponseEntity<PersonTO> updatePerson(@RequestBody PersonTO personTO) {
        PersonTO updatedPerson = personService.updatePerson(personTO);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }


    @DeleteMapping("/persons")
    public ResponseEntity<PersonTO> deletePersons() {
        personService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable int id){
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
