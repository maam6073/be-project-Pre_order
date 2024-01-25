package com.dohyeong.preorder.member.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
public class Member {

    //pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberid;

    //이메일
    @Column(nullable = false, unique = true)
    private String email;

    //비밀번호
    @Column(nullable = false, length = 100)
    private String password;

    //자기소개
    @Column(nullable = false)
    private String description;

    //사진 url
    private String profile_img;

}
