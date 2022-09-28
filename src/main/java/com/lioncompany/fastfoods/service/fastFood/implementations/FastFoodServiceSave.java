package com.lioncompany.fastfoods.service.fastFood.implementations;


import com.lioncompany.fastfoods.dao.IFastFoodDao;
import com.lioncompany.fastfoods.dto.FastFoodTO;
import com.lioncompany.fastfoods.entity.FastFood;
import com.lioncompany.fastfoods.service.fastFood.interfaces.IFastFoodServiceSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FastFoodServiceSave implements IFastFoodServiceSave {

    @Autowired
    IFastFoodDao fastFoodDao;

    @Override
    public FastFood execute(FastFoodTO fastFoodTO) {
        FastFood fastFood = new FastFood();

        fastFood.setName(fastFoodTO.getName().toUpperCase());
        fastFood.setCreatedDate(new Date());
        fastFood.setUpdatedDate(new Date());

        return fastFoodDao.save(fastFood);
    }
}
