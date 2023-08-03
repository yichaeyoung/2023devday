package com.donga.allergy.Controller.Member;

import com.donga.allergy.Service.AllergyService;
import com.donga.allergy.Service.MemberService;
import com.donga.allergy.domain.Allergy.Allergy;
import com.donga.allergy.domain.MemberDomain.Address;
import com.donga.allergy.domain.MemberDomain.Authority;
import com.donga.allergy.domain.MemberDomain.Member;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    @Autowired MemberService memberService;

    @Autowired AllergyService allergyService;

    @GetMapping("/members/new")
    public String createMember(Model model){
        model.addAttribute("memberForm",new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String joinMember(@Valid MemberForm form, BindingResult result){
        if(result.hasErrors()){
            System.out.println(result);
            return "members/createMemberForm";
        }
        Address address = new Address(form.getCity(),form.getStreet(),form.getZipcode());
        Member member = Member.createMember(form.getId(), form.getPw(), form.getName(),address, Authority.USER);
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> member = memberService.findMembers();
        model.addAttribute("members",member);
        return "/members/memberList";
    }

    @GetMapping("/members/updateAllergy")
    public String plusAllergy(Model model){
        List<Member> members = memberService.findMembers();
        List<Allergy> allergys = allergyService.findAllergys();
        model.addAttribute("members",members);
        model.addAttribute("allergys",allergys);
        return "/members/updateAllergy";
    }

    @PostMapping("/members/updateAllergy")
    public String plusAllergy(@RequestParam("memberId") String memberId, @RequestParam("allergyId") Long allergyId){
        Member findmember = memberService.findmember(memberId);
        Allergy allergy = allergyService.findAllergy(allergyId);
        memberService.plusAllergy(findmember,allergy);
        return "/members/updateAllergy";
    }
}
