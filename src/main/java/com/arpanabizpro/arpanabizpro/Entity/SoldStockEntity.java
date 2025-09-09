package com.arpanabizpro.arpanabizpro.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "sold_stock")
public class SoldStockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @SequenceGenerator(name = "global_seq", sequenceName = "global_sequence", allocationSize = 1)
    private Long id;

    @NotBlank(message = "Item code is required")
    private String itemCode;

    @NotBlank(message = "Item name is required")
    private String itemName;

    @NotBlank(message = "HSN is required")
    private String hsn;

    @DecimalMin(value = "0.0", message = "Price must be greater than 0")
    private double price;

    @Min(value = 0, message = "Quantity sold cannot be negative")
    private int quantitySold;

    @Min(value = 0, message = "GST percent cannot be negative")
    private double gstPercent;

    @Min(value = 0, message = "GST amount cannot be negative")
    private double gstAmount;

    @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than 0")
    private double totalAmount;

    @NotNull(message = "Sale date is required")
    private LocalDate saleDate;

}
