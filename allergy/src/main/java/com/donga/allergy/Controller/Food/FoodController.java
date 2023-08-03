package com.donga.allergy.Controller.Food;

import com.donga.allergy.Repository.foodRepository;
import com.donga.allergy.Repository.foodSearch;
import com.donga.allergy.Service.FoodService;
import com.donga.allergy.domain.Food.Food;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FoodController {


    @Autowired FoodService foodService;


    @GetMapping("/food/new")
    public String createFood(Model model){
        model.addAttribute("FoodForm",new FoodForm());
        return "/foods/createFoodForm";
    }
    @PostMapping("/food/new")
    public String createFood(@Valid FoodForm foodForm, BindingResult result){
        if(result.hasErrors()){
            return "/foods/createFoodForm";
        }
        Food food = new Food(foodForm.getName(),foodForm.getOrigin(),foodForm.getProducer());
        foodService.joinFood(food);
        return "redirect:/";
    }

    @GetMapping("/foods")
    public String foodList(@ModelAttribute("foodSearch") foodSearch foodSearch, Model model){
        List<Food> foods = foodService.findFoods(foodSearch);
        model.addAttribute("foods",foods);
        return "foods/foodList";
    }
}
