package com.capstone_project.repositories;

import com.capstone_project.models.Merchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nedwaldie on 2/20/17.
 */
@Repository
public interface Merchants extends CrudRepository<Merchant, Integer>{
    @Query("select m from Merchant m where m.category.id=?1")
    public List<Merchant> findByCategory(int categoryId);
}
