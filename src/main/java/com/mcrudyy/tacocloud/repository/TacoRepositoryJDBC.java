package com.mcrudyy.tacocloud.repository;

import com.mcrudyy.tacocloud.data.Ingredient;
import com.mcrudyy.tacocloud.data.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class TacoRepositoryJDBC implements TacoRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Taco save(Taco taco) {
        return null;
    }

    private long saveTacoInfo(Taco taco){
        taco.setCreatedAt(new Date());

        return 0;
    }

    private void saveIngradientToTaco(Ingredient ingredient, long tacoId) {

    }
}
