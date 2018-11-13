package com.mcrudyy.tacocloud.repository;

import com.mcrudyy.tacocloud.data.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findById(String id);

    Ingredient save(Ingredient ingredient);
}
