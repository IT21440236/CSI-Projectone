package com.csi.projectone.service;

import com.csi.projectone.to.PersonTO;
import com.csi.projectone.model.Person;
import com.csi.projectone.repo.PersonRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private ModelMapper modelMapper;

    //save person
    public PersonTO savePerson(PersonTO personTO){
        personRepo.save(modelMapper.map(personTO, Person.class));

        return personTO;
    }

    //get all persons
    public List<PersonTO> getAllPersons(){
        List<Person> personList = personRepo.findAll();
        return modelMapper.map(personList, new TypeToken<List<PersonTO>>(){}.getType());
    }

    //get person using id
    public Optional<PersonTO> getSinglePerson(int id){
        Optional<Person> person = personRepo.findPersonById(id);
        return modelMapper.map(person, new TypeToken<Optional<PersonTO>>(){}.getType());

    }

    //update person
    public PersonTO updatePerson(PersonTO personTO){
        personRepo.save(modelMapper.map(personTO, Person.class));
        return personTO;
    }

    //delete all
    public ResponseEntity<PersonTO> deleteAll(){
        personRepo.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //delete person using id
    public void deletePersonById(int id){
        personRepo.deletePersonById(id);
    }


}//end of PersonService Class
