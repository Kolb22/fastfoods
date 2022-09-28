package com.lioncompany.fastfoods.service.fastFood.implementations;

import com.lioncompany.fastfoods.dao.IFastFoodDao;
import com.lioncompany.fastfoods.entity.FastFood;
import com.lioncompany.fastfoods.service.fastFood.interfaces.IFastFoodServiceFindAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FastFoodServiceFindAll implements IFastFoodServiceFindAll {

    @Autowired
    IFastFoodDao fastFoodDao;

    @Override
    public List<FastFood> execute() {
        return (List<FastFood>) fastFoodDao.findAll();
    }
}
