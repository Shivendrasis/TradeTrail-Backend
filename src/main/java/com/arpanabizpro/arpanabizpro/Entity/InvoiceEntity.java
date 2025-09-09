package com.arpanabizpro.arpanabizpro.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "invoices")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Customer Info
    private String fullName;
    private String contactNo;
    private String address;
    private String gstin;
    private String deliveryAddress;

    // Totals
    private BigDecimal totalAmount;   // subtotal before tax
    private BigDecimal gst;
    private BigDecimal igst;
    private BigDecimal gstTotal;
    private BigDecimal transport;
    private BigDecimal discount;
    private BigDecimal netTotal;

    // Payment
    private BigDecimal cash;
    private BigDecimal cardUpi;
    private BigDecimal cheque;
    private String chequeNo;
    private String bank;
    private BigDecimal balance;

    // Relationship with items
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<InvoiceItemEntity> items = new ArrayList<>();



    // Utility to add items
    public void addItem(InvoiceItemEntity item) {
        items.add(item);
        item.setInvoice(this);
    }

    public void removeItem(InvoiceItemEntity item) {
        items.remove(item);
        item.setInvoice(null);
    }

    // getters & setters



}
