package com.mcrudyy.tacocloud.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepositoryJDBC implements IngredientRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public IngredientRepositoryJDBC(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // TODO Перевірити чи буде воно працювати якщо прописати @Autowired над jdbc

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient findOne(String id) {
        return null;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }
}
