package com.donga.allergy.domain;

import com.donga.allergy.domain.Food.MenuFood;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu{
    @Id
    @GeneratedValue
    @Column(name="menu_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "menu")
    private List<MenuFood> food = new ArrayList<>();
}
