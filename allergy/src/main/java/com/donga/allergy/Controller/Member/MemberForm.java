package com.donga.allergy.Controller.Member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
    @NotEmpty(message = "아이디는 필수입니다" )
    private String id;
    @NotEmpty(message = "비밀번호는 필수입니다" )
    private String pw;
    @NotEmpty(message = "회원이름은 필수입니다")
    private String name;
    private String city;
    private String street;
    private String zipcode;

    @Override
    public String toString() {
        return "MemberForm{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}

