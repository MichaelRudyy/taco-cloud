package com.mcrudyy.tacocloud.repository;

import com.mcrudyy.tacocloud.data.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        return jdbc.query("select id,name,type from Ingedient", this::mapRowToIngredient)
    }

    @Override
    public Ingredient findOne(String id) {
        return null;
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return null;
    }

    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(
                rs.getString("id"),
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
    }
}
