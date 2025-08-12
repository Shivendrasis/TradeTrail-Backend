package com.arpanabizpro.arpanabizpro.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "purchase_items")
public class PurchaseItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String itemCode;
    private String itemName;
    private String hsn;
    private double rate;
    private double discountPercent;
    private double discountAmount;
    private double netRate;
    private int quantity;
    private String uom;
    private double gstPercent;
    private double mrp;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_id")
    @JsonBackReference
    private PurchaseEntity purchase;
}
