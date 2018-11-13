package com.mcrudyy.tacocloud.repository;

import com.mcrudyy.tacocloud.data.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository
        extends CrudRepository<Taco, Long> {
}
