package com.donga.allergy.domain.Food;

import com.donga.allergy.domain.Allergy.Allergy;
import com.donga.allergy.domain.Menu;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food {
    @Id
    @GeneratedValue
    @Column(name="food_id")
    private Long id;
    private String name;
    private String origin;
    private String producer;

    public Food(String name, String origin, String producer) {
        this.name = name;
        this.origin = origin;
        this.producer = producer;
    }
}
