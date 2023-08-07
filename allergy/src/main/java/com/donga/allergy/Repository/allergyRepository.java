package com.donga.allergy.Repository;

import com.donga.allergy.domain.Allergy.Allergy;
import com.donga.allergy.domain.Allergy.MemberAllergy;
import com.donga.allergy.domain.Food.AllergyFood;
import com.donga.allergy.domain.Food.Food;
import com.donga.allergy.domain.MemberDomain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class allergyRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save(Allergy allergy){
        em.persist(allergy);
    }

    public Allergy findOne(Long id){ return em.find(Allergy.class,id);}
    public List<Allergy> findAll(){
        return em.createQuery("select a from Allergy a", Allergy.class).getResultList();
    }
    public void plusFood(Allergy allergy, Food food){
        AllergyFood allergyFood = new AllergyFood(food,allergy);
        em.persist(allergyFood);
        allergy.getFood().add(allergyFood);
    }
}
