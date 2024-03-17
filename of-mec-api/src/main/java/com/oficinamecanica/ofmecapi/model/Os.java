package com.oficinamecanica.ofmecapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_service")
@Getter
@Setter
@NoArgsConstructor
public class Os {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String date;

    @Column
    private String forecast;

    @Column
    private Integer value;

    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_chassi")
    private Integer carChassi;

    @Column(name = "car_year")
    private Integer carYear;

    @Column(name = "car_plaque")
    private String carPlaque;

    @Column(name = "car_km")
    private Integer carKm;

    @Column(name = "client_id") // Remova esta linha
    private Integer clientId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_quant")
    private Integer productQuant;

    @Column(name = "product_total")
    private Integer productTotal;

    @Column(name = "service_professional_id")
    private Integer serviceProfessionalId;

    @Column(name = "service_description")
    private String serviceDescription;

    @Column(name = "service_value")
    private Integer serviceValue;

    @Column
    private String obs;

    @Column
    private String description;
}




