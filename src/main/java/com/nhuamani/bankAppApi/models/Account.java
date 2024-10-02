package com.nhuamani.bankAppApi.models;

import com.nhuamani.bankAppApi.models.enums.EType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String accountNumber;
    private Boolean status = true;
    private double balance;
    @Enumerated(EnumType.STRING)
    private EType accountType;
    private String customerId;

}
