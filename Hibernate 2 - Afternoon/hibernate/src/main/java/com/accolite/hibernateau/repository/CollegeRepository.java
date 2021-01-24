package com.accolite.hibernateau.repository;

import com.accolite.hibernateau.entity.College;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CollegeRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void addCollege(College college){
        entityManager.persist(college);
    }

    public College getCollegeById(int id){
        return entityManager.find(College.class, id);
    }

    public void deleteCollege(College college){
        entityManager.remove(college);
    }

    public College updateCollege(College college){
        return entityManager.merge(college);
    }

    public List<College> getCollegeUsingQuery(int year, String language) {
        Query query =
                entityManager.createQuery("select m from college m where m.releaseYear > :rel_year and m.lang = :language");
        query.setParameter("rel_year", year);
        query.setParameter("language", language);
        entityManager.createNativeQuery("select * from college m where m.release_year > 0");
        return query.getResultList();
    }

}
