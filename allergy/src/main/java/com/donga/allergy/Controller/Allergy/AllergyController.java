package com.donga.allergy.Controller.Allergy;

import com.donga.allergy.Repository.foodSearch;
import com.donga.allergy.Service.AllergyService;
import com.donga.allergy.Service.FoodService;
import com.donga.allergy.domain.Allergy.Allergy;
import com.donga.allergy.domain.Food.Food;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AllergyController {


    @Autowired
    AllergyService allergyService;
    @Autowired
    FoodService foodService;

    @GetMapping("/allergy/new")
    public String createFood(Model model){
        model.addAttribute("allergyForm",new allegyForm());
        return "/allergys/createAllergyForm";
    }
    @PostMapping("/allergy/new")
    public String createFood(@Valid allegyForm allergyForm, BindingResult result){
        if(result.hasErrors()){
            return "/allergys/createAllergyForm";
        }
        Allergy allergy = new Allergy(allergyForm.getName());
        allergyService.joinAllergy(allergy);
        return "redirect:/";
    }

    @GetMapping("/allergys")
    public String list(Model model){
        List<Allergy> allergyList = allergyService.findAllergys();
        model.addAttribute("allergys",allergyList);
        return "/allergys/allergyList";
    }
    @GetMapping("/allergys/updateFood")
    public String updateFood(Model model){
        model.addAttribute("allergys",allergyService.findAllergys());
        model.addAttribute("foods",foodService.findFoods(new foodSearch()));
        return "/allergys/updateAllergyFood";
    }
    @PostMapping("/allergys/updateFood")
    public String updateFood(@RequestParam("allergyId") Long allergyId, @RequestParam("foodId") Long foodId){
        Allergy allergy = allergyService.findAllergy(allergyId);
        Food food = foodService.findFood(foodId);
        allergyService.updateAllergyFood(allergy,food);
        return "/allergys/updateAllergyFood";
    }
}
