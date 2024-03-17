package com.oficinamecanica.ofmecapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String description;

    @Column
    private String marca;

    @Column
    private String fornecedor;

    @Column
    private Integer valueCust;

    @Column
    private Integer valueMargem;

    @Column
    private Integer valueVenda;

    @Column
    private String validation;

    @Column
    private Integer value;

    @Column
    private Integer stock;
}


