package com.qgerson.twitterservice.adapters;

import com.qgerson.twitterservice.domain.Tweet;
import com.qgerson.twitterservice.ports.TwitterRepositoryPort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Repository
public class TwitterRepositoryAdapter {
/*TwitterRepositoryPort
    public void add(String user, String text, String location, String languageId, boolean isValid) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        entityManager = factory.createEntityManager();
        Tweet tweet =  new Tweet( user, text, location, languageId, isValid);
        entityManager.persist( tweet );
    }
 */
}
