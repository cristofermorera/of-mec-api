package com.oficinamecanica.ofmecapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String birth;

    @Column
    private String firstDateContract;

    @Column
    private String endDateContract;

    @Column
    private Integer fone;

    @Column
    private Integer cep;

    @Column
    private String nickname;

    @Column
    private String email;

    @Column
    private Integer cpf;

    @Column
    private String address;

    @Column
    private Integer numberAddress;

    @Column
    private String state;

    @Column
    private String obs;

}


