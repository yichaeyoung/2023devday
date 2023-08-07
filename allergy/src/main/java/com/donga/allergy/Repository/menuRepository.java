package com.donga.allergy.Repository;

import com.donga.allergy.domain.Food.Food;
import com.donga.allergy.domain.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class menuRepository {

    @PersistenceContext
    private final EntityManager em;
    public void save(Menu menu) {
        em.persist(menu);
    }

    public Menu findMenu(Long id){
        return em.find(Menu.class,id);
    }

    public List<Menu> findAllMenu(){
        return em.createQuery("select m from Menu m", Menu.class).getResultList();
    }

}
