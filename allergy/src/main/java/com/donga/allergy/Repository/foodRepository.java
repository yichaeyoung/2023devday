package com.donga.allergy.Repository;

import com.donga.allergy.domain.Food.Food;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class foodRepository {

    @PersistenceContext
    private final EntityManager em;

    public void save( Food food){
        em.persist(food);
    }

    public Food findOne(Long id){
        return em.find(Food.class,id);
    }
    public List<Food> find_food(foodSearch foodSearch){
        String jpql = "select f from Food f";
        boolean isFirstCondition = true;
        if (StringUtils.hasText(foodSearch.getFood_name())){
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " f.name like :name";
        }
        TypedQuery<Food> query = em.createQuery(jpql, Food.class).setMaxResults(1000);

        if (StringUtils.hasText(foodSearch.getFood_name())) {
            query = query.setParameter("name", foodSearch.getFood_name());
        }
        return query.getResultList();
    }
}
