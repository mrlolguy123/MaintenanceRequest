package com.example.maintenancerequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersonnel() { return personRepository.findAllByOrderByPersonnameAsc(); }

    public Person getPersonById(Integer id) { return personRepository.findById(id).orElse(null); }

    public void deletePerson(Integer id) { personRepository.deleteById(id); }

    public void addPerson(String name, Integer apt, String phone, String email, String checkin, String checkout)
    {
        List<Person> emails = personRepository.findAllByEmailEquals(email);
        List<Person> phones = personRepository.findAllByPhonenumberEquals(phone);
        List<Person> apts = personRepository.findAllByApartmentnumberEquals(apt);

        if(emails.isEmpty() && phones.isEmpty() && apts.isEmpty()) {
            Person p = new Person(name, apt, phone, email, checkin, checkout);
            personRepository.save(p);
        }
    }

    public void updateApartment(Integer id, Integer apt)
    {
        List<Person> apts = personRepository.findAllByApartmentnumberEquals(apt);

        if(apts.isEmpty())
        {
            Person p = getPersonById(id);
            p.setApartmentnumber(apt);
            personRepository.save(p);
        }
    }

    public Person findByEmail(String email)
    {
        List<Person> personList = personRepository.findAllByEmailEquals(email);
        return personList.get(0);
    }
}
