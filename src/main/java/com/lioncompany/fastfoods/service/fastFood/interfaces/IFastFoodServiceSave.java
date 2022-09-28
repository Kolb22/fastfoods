package com.lioncompany.fastfoods.service.fastFood.interfaces;

import com.lioncompany.fastfoods.dto.FastFoodTO;
import com.lioncompany.fastfoods.entity.FastFood;

public interface IFastFoodServiceSave {
    FastFood execute(FastFoodTO fastFoodTO);
}
