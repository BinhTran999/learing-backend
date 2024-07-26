package com.vn.dev.core_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.ws.soap.saaj.SaajAttachmentException;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "dd_nhanvien", schema = "public")

public class DDNhanVien extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "name")
    private String name;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code")
    private String code;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gender")
    private int gender;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phone")
    private String phone;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "birth")
    private Date birth;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "email")
    private String email;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address")
    private String address;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team")
    private String team;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status")
    private boolean status;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order")
    private int order;
}
