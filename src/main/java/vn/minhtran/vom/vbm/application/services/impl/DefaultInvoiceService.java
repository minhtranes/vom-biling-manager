/*
 * Class: DefaultInvoiceService
 *
 * Created on Nov 13, 2020
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.minhtran.vom.vbm.application.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.minhtran.vom.vbm.application.services.InvoiceService;
import vn.minhtran.vom.vbm.infra.entity.InvoiceEntity;
import vn.minhtran.vom.vbm.infra.repository.InvoiceRepository;
import vn.minhtran.vom.vbm.model.Invoice;

@Service
public class DefaultInvoiceService implements InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    @Override
    public Invoice store(Invoice invoice) {
        InvoiceEntity inv = repository.save(toEntity(invoice));
        return toModel(inv);
    }

    private Invoice toModel(InvoiceEntity en) {
        return Invoice.invoiceId(en.getName()).checkInDate(en.getCheckInDate())
            .checkOutDate(en.getCheckOutDate()).country(en.getCountry())
            .createdTime(en.getCreatedTime());
    }

    private static InvoiceEntity toEntity(Invoice i) {
        final InvoiceEntity en = new InvoiceEntity();
        {
            en.setGuestName(i.getName());
        }
        return en;
    }

}
