package com.example.halykb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    private Long perNum;  //табельный номер

    private String fio; //ФИО

    private Date birthDate;

    private String role;

    public Users(Long perNum, String fio, Date birthDate, String role) {
        this.perNum = perNum;
        this.fio = fio;
        this.birthDate = birthDate;
        this.role = role;
    }
}
