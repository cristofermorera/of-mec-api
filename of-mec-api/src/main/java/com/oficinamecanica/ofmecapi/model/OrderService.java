package com.oficinamecanica.ofmecapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderService {
    private Long orderId;
    private String orderDate;
    private String orderForecast;
    private int orderValue;
    private int carId;
    private String carName;
    private int carChassi;
    private int carYear;
    private String carPlaque;
    private int carKm;
    private int clientId;
    private Integer productId;
    private Integer productQuant;
    private Integer productTotal;
    private int serviceProfessionalId;
    private String serviceDescription;
    private int serviceValue;
    private String obs;
    private String description;
    private Client client;
    private Employee employee;
    private Product product;

    // Getters and setters
}
