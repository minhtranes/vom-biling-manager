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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.minhtran.vom.vbm.application.services.InvoiceService;
import vn.minhtran.vom.vbm.infra.entity.InvoiceEntity;
import vn.minhtran.vom.vbm.infra.repository.InvoiceRepository;
import vn.minhtran.vom.vbm.model.Invoice;

@Service
public class DefaultInvoiceService implements InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    @Override
    public Invoice store(Invoice invoice) throws JsonProcessingException {
        String invoiceId = invoice.getInvoiceId();
        InvoiceEntity invoiceEntity = repository.findOneByName(invoiceId);
        if (invoiceEntity == null) {
            invoiceEntity = new InvoiceEntity();
        }
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        objectMapper.setDateFormat(dateFormat);
        updateEntity(invoice, invoiceEntity, objectMapper);
        InvoiceEntity inv = repository.save(invoiceEntity);
        return toModel(inv);
    }

    private Invoice toModel(InvoiceEntity en) {
        return Invoice.invoiceId(en.getName())
            .createdTime(en.getCreatedTime()).id(en.getId())
            .lastModifiedTime(en.getLastModifiedTime()).name(en.getGuestName());
    }

    @Autowired
    private ObjectMapper objectMapper;

    private static void updateEntity(
        Invoice i,
        InvoiceEntity en,
        ObjectMapper objectMapper) throws JsonProcessingException {
        en.setName(i.getInvoiceId());
        en.setGuestName(i.getName());
        en.setCheckInDate(i.getCheckInDate().atOffset(ZoneOffset.UTC));
        en.setCheckOutDate(i.getCheckOutDate().atOffset(ZoneOffset.UTC));
        en.setCountry(i.getCountry());
        en.setPaidAmount(i.getPaidAmount());
        en.setTotalAmount(i.getTotalAmount());
        en.setRemainAmount(i.getRemainAmount());
        en.setRawData(objectMapper.writeValueAsString(i));
        en.setRooms(i.getSheetName());
        en.setPdfLink(i.getPdfLink());
    }

}
