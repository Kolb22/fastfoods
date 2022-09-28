package com.lioncompany.fastfoods.dao;

import com.lioncompany.fastfoods.entity.FastFood;
import org.springframework.data.repository.CrudRepository;

public interface IFastFoodDao extends CrudRepository<FastFood, Long> {
}
