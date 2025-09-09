package com.arpanabizpro.arpanabizpro.Service;

import com.arpanabizpro.arpanabizpro.Entity.InvoiceEntity;

import java.util.List;

public interface InvoiceService {

    InvoiceEntity calculateInvoice(InvoiceEntity invoiceEntity);

    InvoiceEntity saveInvoice(InvoiceEntity invoiceEntity);

    InvoiceEntity getInvoiceById(Long id);

    List<InvoiceEntity> getAllInvoice();
}
