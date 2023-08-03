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
public class AllergyFood {
    @Id
    @GeneratedValue
    @Column(name="Allergyfood_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="food_id")
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "allergy_id")
    private Allergy allergy;

}