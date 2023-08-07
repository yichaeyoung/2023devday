package com.donga.allergy.Repository;

import com.donga.allergy.domain.Allergy.Allergy;
import com.donga.allergy.domain.Allergy.MemberAllergy;
import com.donga.allergy.domain.MemberDomain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class memberRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(String id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findById(String id){
        return em.createQuery("select m from Member m where m.id = :id", Member.class)
                .setParameter("id",id)
                .getResultList();
    }

    public void plusAllergy(Member member,Allergy allergy){
        MemberAllergy memberAllergy = new MemberAllergy(allergy,member);
        em.persist(memberAllergy);
        member.getAllergyList().add(memberAllergy);
    }
}
