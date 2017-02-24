package com.capstone_project.repositories;

import com.capstone_project.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nedwaldie on 2/23/17.
 */
@Repository
public interface Categories extends CrudRepository<Category, Integer>{
    @Query("SELECT c FROM Category c where c.category like ?1")
    public List<Category> findByCategory(String category);
}
