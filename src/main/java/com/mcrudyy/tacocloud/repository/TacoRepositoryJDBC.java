package com.mcrudyy.tacocloud.repository;

import com.mcrudyy.tacocloud.data.TacoDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TacoRepositoryJDBC implements TacoRepository {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public TacoDesign save(TacoDesign taco) {
        return null;
    }
}
