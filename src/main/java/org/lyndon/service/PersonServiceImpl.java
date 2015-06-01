package org.lyndon.service;

import org.lyndon.entity.Person;
import org.lyndon.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Lyndon on 30/5/15.
 */
@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void serve() {
        System.out.println(personRepository.count());
        Person person = new Person();
        person.setId(2);
        person.setName("Anne");
        personRepository.save(person);
        System.out.println(personRepository.count());
        personRepository.delete(person);
        System.out.println(personRepository.count());
    }

}
