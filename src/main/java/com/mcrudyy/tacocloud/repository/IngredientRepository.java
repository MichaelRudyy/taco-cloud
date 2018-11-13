package com.mcrudyy.tacocloud.repository;

import com.mcrudyy.tacocloud.data.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}
