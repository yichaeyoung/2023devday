package com.donga.allergy.domain.Allergy;

import com.donga.allergy.domain.Food.Food;
import com.donga.allergy.domain.MemberDomain.Member;
import com.donga.allergy.domain.Menu;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuAllergy {
    @Id
    @GeneratedValue
    @Column(name = "MenuAllergy_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "allergy_id")
    private Allergy allergy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;
    //알러지 메뉴
}