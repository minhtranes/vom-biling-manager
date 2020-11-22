/*
 * Class: InvoiceController
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
package vn.minhtran.vom.vbm.presentation.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import vn.minhtran.vom.vbm.application.services.InvoiceService;
import vn.minhtran.vom.vbm.model.Invoice;
import vn.minhtran.vom.vbm.model.SaveInvoiceResponse;

@RestController
@RequestMapping("/vom")
public class InvoiceController {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(InvoiceController.class);

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    void init() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    @PostMapping("/invoice")
    public SaveInvoiceResponse save(@RequestBody Invoice invoice)
            throws JsonProcessingException {
        LOGGER
            .info("Start process invoice save request [{}]", invoice.getName());
        Invoice i = invoiceService.store(invoice);
        SaveInvoiceResponse res = SaveInvoiceResponse.from(i);
        LOGGER.info(
            "Complete process invoice save request [{}]",
            invoice.getName());
        return res;
    }
}
