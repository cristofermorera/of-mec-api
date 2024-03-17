package com.oficinamecanica.ofmecapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer idClients;

    @Column(name = "name_client")
    private String nameClient;

    @Column
    private String lastname;

    @Column
    private String birth;

    @Column
    private String type;

    @Column
    private String nickname;

    @Column
    private Long fone;

    @Column(name = "email_client")
    private String emailClient;

    @Column
    private Long cpf;

    @Column
    private Long cep;

    @Column
    private String address;

    @Column(name = "number_address")
    private Integer numberAddress;
}



