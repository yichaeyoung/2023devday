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
public class MemberAllergy {
    @Id
    @GeneratedValue
    @Column(name = "MemberAllergy_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="allergy_id")
    private Allergy allergy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public MemberAllergy(Allergy allergy, Member member) {
        this.allergy = allergy;
        this.member = member;
    }
}