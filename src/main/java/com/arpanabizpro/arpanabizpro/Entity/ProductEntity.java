package com.arpanabizpro.arpanabizpro.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Getter
@Data
@Table(name = "products")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
        @SequenceGenerator(name = "global_seq", sequenceName = "global_sequence", allocationSize = 1)
        private Long id;

        @NotBlank(message = "Item code is required")
        @Column(name = "item_code", unique = true, nullable = false)
        private String itemCode;

        @NotBlank(message = "Company is required")
        private String company;

        @NotBlank(message = "Item name is required")
        private String item;

        private String description;

        @NotBlank(message = "HSN is required")
        private String hsn;

        @Min(value = 0, message = "GST percent cannot be negative")
        private double gstPercent;

        @Min(value = 0, message = "Quantity cannot be negative")
        private int quantity;

        @DecimalMin(value = "0.0", inclusive = false, message = "MRP must be greater than 0")
        private double mrp;

        @DecimalMin(value = "0.0", inclusive = false, message = "Cost Price must be greater than 0")
        private double cp;


    }

     //fields visible on the "Add Product" screen in your U