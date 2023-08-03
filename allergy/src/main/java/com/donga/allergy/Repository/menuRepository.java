package com.donga.allergy.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class menuRepository {

    @PersistenceContext
    private final EntityManager em;
}
