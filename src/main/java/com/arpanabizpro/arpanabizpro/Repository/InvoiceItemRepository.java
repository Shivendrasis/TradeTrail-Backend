package com.arpanabizpro.arpanabizpro.Repository;

import com.arpanabizpro.arpanabizpro.Entity.InvoiceItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItemEntity, Long> {
}
