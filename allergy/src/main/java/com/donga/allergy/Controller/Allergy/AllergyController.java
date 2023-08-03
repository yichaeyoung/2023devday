package com.donga.allergy.Controller.Allergy;

import com.donga.allergy.Service.AllergyService;
import com.donga.allergy.domain.Allergy.Allergy;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AllergyController {


    @Autowired
    AllergyService allergyService;


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
}
