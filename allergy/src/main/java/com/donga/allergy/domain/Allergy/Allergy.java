package com.donga.allergy.domain.Allergy;

import com.donga.allergy.domain.Food.AllergyFood;
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
public class Allergy {
    @Id
    @GeneratedValue
    @Column(name = "allergy_id")
    private Long id;
    //id
    @Column(nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "allergy")
    private List<AllergyFood> food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    public Allergy(String name) {
        this.name = name;
    }
}

