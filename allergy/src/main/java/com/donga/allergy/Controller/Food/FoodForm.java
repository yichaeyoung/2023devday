package com.donga.allergy.Controller.Food;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodForm{
    @NotEmpty(message = "이름은 필수입니다" )
    private String name;
    @NotEmpty(message = "원산지는 필수입니다" )
    private String origin;
    @NotEmpty(message = "생산자는 필수입니다" )
    private String producer;
}
