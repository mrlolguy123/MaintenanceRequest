package com.example.maintenancerequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findAllByOrderByPersonnameAsc();

    List<Person> findAllByApartmentnumberEquals(Integer aptNum);

    List<Person> findAllByPhonenumberEquals(String phoneNum);

    List<Person> findAllByEmailEquals(String email);
}
