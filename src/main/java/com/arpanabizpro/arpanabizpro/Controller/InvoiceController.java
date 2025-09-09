package com.arpanabizpro.arpanabizpro.Controller;

import com.arpanabizpro.arpanabizpro.Entity.InvoiceEntity;
import com.arpanabizpro.arpanabizpro.Service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    // Save Invoice
    @PostMapping
    public InvoiceEntity createInvoice(@RequestBody InvoiceEntity invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    //getInvoice by id
    @GetMapping("/{id}")
    public InvoiceEntity getInvoice(@PathVariable Long id){
        return invoiceService.getInvoiceById(id);
    }

    //get all invoices
    @GetMapping("/getAll")
    public List<InvoiceEntity> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }
}
