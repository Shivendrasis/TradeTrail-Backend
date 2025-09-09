package com.arpanabizpro.arpanabizpro.Service.ProductServiceImpl;

import com.arpanabizpro.arpanabizpro.Entity.InvoiceEntity;
import com.arpanabizpro.arpanabizpro.Entity.InvoiceItemEntity;
import com.arpanabizpro.arpanabizpro.Repository.InvoiceRepository;
import com.arpanabizpro.arpanabizpro.Service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceServiceImplimentation implements InvoiceService {

    @Autowired
    private final InvoiceRepository invoiceRepository;

    @Override
    public InvoiceEntity calculateInvoice(InvoiceEntity invoiceEntity) {

        BigDecimal grossAmount = BigDecimal.ZERO; // sum of exTax (Rate × Qty) for all items
        BigDecimal gstTotal = BigDecimal.ZERO;    // sum of GST amount for all items

        // 1. Loop through all invoice items and calculate values
        for (InvoiceItemEntity item : invoiceEntity.getItems()) {

            // Ensure rate and qty are not null
            BigDecimal rate = defaultIfNull(item.getRate());
            Integer qtyObj = item.getQty();   // wrapper Integer
            int qty = (qtyObj != null) ? qtyObj : 0;

            // exTax = rate * qty
            BigDecimal exTax = rate.multiply(BigDecimal.valueOf(qty));
            item.setExTaxAdd(exTax);

            // GST% should come from gstPercent field (not gstAmount!)
            BigDecimal gstPercent = defaultIfNull(item.getGstPercent());

            // gstAmount = exTax * gstPercent / 100 (with rounding)
            BigDecimal gstAmount = exTax.multiply(gstPercent)
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
            item.setGstAmount(gstAmount);

            // total = exTax + gst
            BigDecimal total = exTax.add(gstAmount);
            item.setTotal(total);

            // Link this item to the invoice (important for JPA persistence)
            item.setInvoice(invoiceEntity);

            // Add to invoice-level totals
            grossAmount = grossAmount.add(exTax);
            gstTotal = gstTotal.add(gstAmount);
        }

        // 2. Invoice totals
        invoiceEntity.setTotalAmount(grossAmount);
        invoiceEntity.setGstTotal(gstTotal);

        // Example: assuming all GST is intra-state, IGST = 0
        invoiceEntity.setGst(gstTotal);
        invoiceEntity.setIgst(BigDecimal.ZERO);

        // netTotal = Gross + GST + Transport – Discount
        BigDecimal netTotal = grossAmount.add(gstTotal);

        if (invoiceEntity.getTransport() != null) {
            netTotal = netTotal.add(invoiceEntity.getTransport());
        }
        if (invoiceEntity.getDiscount() != null) {
            netTotal = netTotal.subtract(invoiceEntity.getDiscount());
        }

        invoiceEntity.setNetTotal(netTotal);

        // 3. Payments & Balance
        BigDecimal paid = defaultIfNull(invoiceEntity.getCash())
                .add(defaultIfNull(invoiceEntity.getCardUpi()))
                .add(defaultIfNull(invoiceEntity.getCheque()));

        // balance = netTotal - paid
        BigDecimal balance = netTotal.subtract(paid);
        invoiceEntity.setBalance(balance);

        return invoiceEntity;
    }

    @Override
    public InvoiceEntity saveInvoice(InvoiceEntity invoiceEntity) {
        calculateInvoice(invoiceEntity);
        return invoiceRepository.save(invoiceEntity);
    }

    @Override
    public InvoiceEntity getInvoiceById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id " + id));
    }

    @Override
    public List<InvoiceEntity> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    /**
     * Helper method: if a BigDecimal is null, return ZERO instead.
     */
    private BigDecimal defaultIfNull(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }
}
