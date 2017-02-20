package com.capstone_project.repositories;

import com.capstone_project.models.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nedwaldie on 2/20/17.
 */
@Repository
public interface Merchants extends CrudRepository<Merchant, Integer>{
}
