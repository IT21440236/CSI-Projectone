package com.csi.projectone.repo;

import com.csi.projectone.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Long> {

    Optional<Person> findPersonById(int id);

    void deletePersonById(int id);
}
