package com.arpanabizpro.arpanabizpro.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "invoice_items")
public class InvoiceItemEntity {

    //Holds product-level details.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemCode;
    private String item;
    private String hsn;
    private BigDecimal rate;
    private Integer qty;   // ✅ use wrapper class, not primitive
    private String uom;         // nos, kg, etc.
    private BigDecimal gstPercent;

    // Calculated fields
    private BigDecimal exTaxAdd;   // rate × qty
    private BigDecimal gstAmount;  // GST calculated
    private BigDecimal total;      // exTaxAdd + gstAmount

    // Relationship back to invoice
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference   // ✅ this breaks the cycle
    @JoinColumn(name = "invoice_id")

    private InvoiceEntity invoice;

    //getter and setter
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

}
