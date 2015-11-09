package org.lyndon.repository1;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.lyndon.vo.SearchResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Lyndon on 11/9/15.
 */
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext(unitName = "springEntityManagerFactory")
    private EntityManager entityManager;

    public List<SearchResult> find() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.getNamedQuery("custom");
        query.setString("name", "Lyndon");
        query.setResultTransformer(Transformers.aliasToBean(SearchResult.class));
        List<SearchResult> result = query.list();
        for (SearchResult searchResult : result) {
            System.out.println(searchResult.getName());
        }
        return result;
    }

}
