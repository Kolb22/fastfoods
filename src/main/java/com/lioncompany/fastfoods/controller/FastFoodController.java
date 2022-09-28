package com.lioncompany.fastfoods.controller;

import com.lioncompany.fastfoods.dto.FastFoodTO;
import com.lioncompany.fastfoods.dto.UserTO;
import com.lioncompany.fastfoods.entity.FastFood;
import com.lioncompany.fastfoods.entity.User;
import com.lioncompany.fastfoods.service.fastFood.interfaces.IFastFoodServiceFindAll;
import com.lioncompany.fastfoods.service.fastFood.interfaces.IFastFoodServiceSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@CrossOrigin({"*"})
@RestController
@RequestMapping("/api")
public class FastFoodController {

    @Autowired
    IFastFoodServiceSave fastFoodServiceSave;

    @Autowired
    IFastFoodServiceFindAll fastFoodServiceFindAll;

    @PostMapping("/fast-food")
    public ResponseEntity<?> create(@RequestBody FastFoodTO fastFoodTO) {
        Map<String, Object> errorResponse = new HashMap<>();
        FastFood fastFood;

        try{
            fastFood = fastFoodServiceSave.execute(fastFoodTO);
        } catch (Exception e){
            errorResponse.put("error", "Something has happened trying to create the fast food. Please try again later.");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(fastFood, HttpStatus.OK);
    }

    @GetMapping("/fast-food")
    public ResponseEntity<?> randomFastFood() {
        Map<String, Object> errorResponse = new HashMap<>();
        List<FastFood> fastFoods;
        FastFoodTO fastFoodTO = new FastFoodTO();

        try{
            Random random = new Random();
            fastFoods = fastFoodServiceFindAll.execute();
            fastFoodTO.setName(fastFoods.get(random.nextInt(fastFoods.size())).getName());
        } catch (Exception e){
            errorResponse.put("error", "Something has happened trying to search the fast foods. Please try again later.");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(fastFoodTO, HttpStatus.OK);
    }
}
