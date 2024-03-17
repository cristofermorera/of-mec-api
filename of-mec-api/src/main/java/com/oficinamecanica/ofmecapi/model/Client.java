package com.oficinamecanica.ofmecapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Client {
    private int clientId;
    private String clientName;
    private String clientLastName;
    private String clientBirth;
    private String clientType;
    private String clientNickname;
    private long clientPhone;
    private String clientEmail;
    private long clientCPF;
    private int clientCEP;
    private String clientAddress;
    private long clientAddressNumber;
}