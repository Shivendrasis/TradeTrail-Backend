package com.arpanabizpro.arpanabizpro.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Entity
@Data
@Table(name = "purchase")
public class PurchaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @SequenceGenerator(name = "global_seq", sequenceName = "global_sequence", allocationSize = 1)
    private Long id;

    //Supplier details
    private String supplier;
    private String purchaseDate;
    private String billNo;

    //Amount summary
    private double totalAmount;
    private double gst;
    private double igst;
    private double gstTotal;
    private double otherCharges;
    private double discount;
    private double netTotal;

    private double cash;
    private double card;
    private double cheque;
    private String chequeNo;
    private String bank;
    private double balance;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PurchaseItemsEntity> items;
}
