package com.csi.projectone;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.csi.projectone.model.Person;
import com.csi.projectone.repo.PersonRepo;
import com.csi.projectone.service.PersonService;
import com.csi.projectone.to.PersonTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.modelmapper.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonServiceTest {


    private PersonService personService;

    private PersonRepo personRepo;
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        personRepo = mock(PersonRepo.class);
        modelMapper = mock(ModelMapper.class);
        personService = new PersonService(personRepo, modelMapper);
    }

    @Test
    public void testSavePerson() {
        // Arrange
        PersonTO personTO = new PersonTO(/* initialize with data */);
        Person person = new Person(/* initialize with data */);

        when(modelMapper.map(personTO, Person.class)).thenReturn(person);
        // You may also want to mock the personRepo.save() method depending on your needs

        // Act
        PersonTO result = personService.savePerson(personTO);

        // Assert
        assertNotNull(result);
        // Add more assertions here based on your requirements
    }

    @Test
    public void testGetAllPersons() {
        // Arrange
        List<Person> personList = new ArrayList<>(); // Initialize with test data
        List<PersonTO> personTOList = new ArrayList<>(); // Initialize with expected results

        when(personRepo.findAll()).thenReturn(personList);
        when(modelMapper.map(personList, new TypeToken<List<PersonTO>>(){}.getType())).thenReturn(personTOList);

        // Act
        List<PersonTO> result = personService.getAllPersons();

        // Assert
        assertNotNull(result);
        // Add more assertions here based on your requirements
    }

    @Test
    public void testGetSinglePerson() {
        // Arrange
        int personId = 1; // Provide a valid person ID
        Optional<Person> person = Optional.of(new Person(/* initialize with data */));
        Optional<PersonTO> personTO = Optional.of(new PersonTO(/* initialize with data */));

        when(personRepo.findPersonById(personId)).thenReturn(person);
        when(modelMapper.map(person, new TypeToken<Optional<PersonTO>>(){}.getType())).thenReturn(personTO);

        // Act
        Optional<PersonTO> result = personService.getSinglePerson(personId);

        // Assert
        assertTrue(result.isPresent());
        // Add more assertions here based on your requirements
    }

    @Test
    public void testUpdatePerson() {
        // Arrange
        PersonTO personTO = new PersonTO(/* initialize with data */);
        Person person = new Person(/* initialize with data */);

        when(modelMapper.map(personTO, Person.class)).thenReturn(person);
        // You may also want to mock the personRepo.save() method depending on your needs

        // Act
        PersonTO result = personService.updatePerson(personTO);

        // Assert
        assertNotNull(result);
        // Add more assertions here based on your requirements
    }

    @Test
    public void testDeleteAll() {
        // Arrange
        // Mock the personRepo.deleteAll() method to return void or handle it based on your needs

        // Act
        ResponseEntity<PersonTO> result = personService.deleteAll();

        // Assert
        assertNotNull(result);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        // Add more assertions here based on your requirements
    }
}
