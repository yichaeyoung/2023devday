package com.donga.allergy.domain.MemberDomain;

import com.donga.allergy.domain.Allergy.Allergy;
import com.donga.allergy.domain.Allergy.MemberAllergy;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(AccessLevel.PROTECTED)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Column(name="member_id")
    private String id;

    @Column(nullable = false)
    private String password;

    private String name;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToMany(mappedBy = "member")
    private List<MemberAllergy> allergyList = new ArrayList<>();

    public static Member createMember(String id, String pw, String name,Address address,Authority authority){
        Member member = new Member();
        member.setId(id);
        member.setPassword(pw);
        member.setName(name);
        member.setAddress(address);
        member.setAuthority(authority);
        return member;
    }

    //===================//
}
