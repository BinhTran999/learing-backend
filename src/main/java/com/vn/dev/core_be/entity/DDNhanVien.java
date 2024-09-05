package com.vn.dev.core_be.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vn.dev.core_be.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "dd_nhanvien2", schema = "public")

public class DDNhanVien extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;


    @Column(name = "code")
    private String code;

    @Column(name = "gender")
    private String gender;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @Column(name = "birth")
    @JsonFormat(pattern = "yyyy.MM.dd")
    private Date birth;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "team")
    private String team;

    @Column(name = "status")
    private boolean status;

    public String toString(){
        return this.name + " " + this.code;
    }

    public boolean getStatus() {
        return this.status;
    }
}
