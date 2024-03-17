package com.oficinamecanica.ofmecapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String birth;
    private String firstDateContract;
    private String endDateContract;
    private long fone;
    private int cep;
    private String nickname;
    private String email;
    private long cpf;
    private String address;
    private int numberAddress;
    private String state;
    private String obs;
}

