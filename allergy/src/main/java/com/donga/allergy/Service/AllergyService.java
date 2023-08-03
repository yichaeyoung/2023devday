package com.donga.allergy.Service;

import com.donga.allergy.Repository.allergyRepository;
import com.donga.allergy.domain.Allergy.Allergy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AllergyService {

    private final allergyRepository allergyRepository;

    @Transactional
    public void joinAllergy(Allergy allergy){ allergyRepository.save(allergy);}

    public Allergy findAllergy(Long id){
        return allergyRepository.findOne(id);
    }

    public List<Allergy> findAllergys(){
        return allergyRepository.findAll();
    }
}
