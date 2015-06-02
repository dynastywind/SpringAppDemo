package org.lyndon.repository1;

import org.lyndon.entity1.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Lyndon on 30/5/15.
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
