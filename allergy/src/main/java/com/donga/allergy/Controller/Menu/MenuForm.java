package com.donga.allergy.Controller.Menu;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuForm {
    @NotEmpty(message = "메뉴이름은 필수입니다")
    private String name;
}

