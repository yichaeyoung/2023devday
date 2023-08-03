package com.donga.allergy.Service;

import com.donga.allergy.Repository.memberRepository;
import com.donga.allergy.Repository.allergyRepository;
import com.donga.allergy.domain.Allergy.Allergy;
import com.donga.allergy.domain.Allergy.MemberAllergy;
import com.donga.allergy.domain.MemberDomain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService{

    @Autowired
    private final memberRepository memberRepository;
    @Autowired
    private final allergyRepository allergyRepository;
    @Transactional
    public String join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> byId = memberRepository.findById(member.getId());
        if(!byId.isEmpty()){
            throw new IllegalStateException("이미 존재하는 아이디입니다");
        }
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Member findmember(String id){
        return memberRepository.findOne(id);
    }

    public void plusAllergy(Member member,Allergy allergy){
        memberRepository.plusAllergy(member,allergy);
    }
}
