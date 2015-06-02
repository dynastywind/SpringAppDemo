package org.lyndon.service;

import org.lyndon.entity1.Person;
import org.lyndon.entity2.TestPerson;
import org.lyndon.repository1.PersonRepository;
import org.lyndon.repository2.TestPersonRepository;
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

    @Autowired
    private TestPersonRepository testPersonRepository;

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
        System.out.println();
        System.out.println(testPersonRepository.count());
        TestPerson testPerson = new TestPerson();
        testPerson.setId(2);
        testPerson.setName("Lyndon");
        testPersonRepository.save(testPerson);
        System.out.println(testPersonRepository.count());
        testPersonRepository.delete(testPerson);
        System.out.println(testPersonRepository.count());
    }

}
