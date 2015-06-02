package org.lyndon.repository2;

import org.lyndon.entity2.TestPerson;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yli on 6/2/2015.
 */
public interface TestPersonRepository extends JpaRepository<TestPerson, Integer> {
}
