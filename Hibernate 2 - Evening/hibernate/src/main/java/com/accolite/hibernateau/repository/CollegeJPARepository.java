package com.accolite.hibernateau.repository;

import com.accolite.hibernateau.entity.College;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CollegeJPARepository extends CrudRepository<College, Integer> {

    public College findCollegeByName(String name);

}
