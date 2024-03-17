package com.oficinamecanica.ofmecapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private int id;
    private String description;
    private String marca;
    private String fornecedor;
    private int valueCust;
    private int valueMargem;
    private int valueVenda;
    private String validation;
    private int value;
    private int stock;
}
