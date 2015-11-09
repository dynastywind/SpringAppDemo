package org.lyndon.service;

import org.lyndon.entity1.Person;
import org.lyndon.entity2.Customers;
import org.lyndon.repository1.PersonRepository;
import org.lyndon.repository1.PersonRepositoryCustom;
import org.lyndon.repository1.PersonRepositoryImpl;
import org.lyndon.repository2.CustomersRepository;
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
    private CustomersRepository customersRepository;
    
    @Autowired
    private PersonRepositoryCustom personRepositoryCustom;

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
        System.out.println(customersRepository.count());
        Customers customers = new Customers();
        customers.setId(2);
        customers.setName("Lyndon");
        customersRepository.save(customers);
        System.out.println(customersRepository.count());
        customersRepository.delete(customers);
        System.out.println(customersRepository.count());

        personRepositoryCustom.find();
    }

}
