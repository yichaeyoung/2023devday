package com.donga.allergy.Controller.Allergy;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class allegyForm {
    @NotEmpty(message = "이름은 필수입니다" )
    private String name;
}
