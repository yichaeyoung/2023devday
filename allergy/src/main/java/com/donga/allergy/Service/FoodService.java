package com.donga.allergy.Service;

import com.donga.allergy.Repository.foodRepository;
import com.donga.allergy.Repository.foodSearch;
import com.donga.allergy.domain.Food.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodService {

    private final foodRepository foodRepository;

    @Transactional
    public void joinFood(Food food){ foodRepository.save(food);}
    public List<Food> findFoods(foodSearch foodSearch){
        return foodRepository.find_food(foodSearch);
    }
}
