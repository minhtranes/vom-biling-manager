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

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.minhtran.vom.vbm.application.services.InvoiceService;
import vn.minhtran.vom.vbm.infra.entity.InvoiceEntity;
import vn.minhtran.vom.vbm.infra.repository.InvoiceRepository;
import vn.minhtran.vom.vbm.model.Invoice;

@Service
public class DefaultInvoiceService implements InvoiceService {

    private static final Logger LOGGER = LoggerFactory
        .getLogger(DefaultInvoiceService.class);

    @Autowired
    private InvoiceRepository repository;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @PostConstruct
    void initDynamo() {

        final DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(
            this.amazonDynamoDB);
        final CreateTableRequest tableRequest = dynamoDBMapper
            .generateCreateTableRequest(
                vn.minhtran.vom.vbm.infra.dynamodb.entity.InvoiceEntity.class);
        try {
            tableRequest
                .setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
            this.amazonDynamoDB.createTable(tableRequest);
        }
        catch (final Exception e) {
            LOGGER.warn(
                "Failed to create table [{}]",
                tableRequest.getTableName());
        }
    }

    @Override
    public Invoice store(final Invoice invoice) throws JsonProcessingException {
        final String invoiceId = invoice.getInvoiceId();
        InvoiceEntity invoiceEntity = this.repository.findOneByName(invoiceId);
        if (invoiceEntity == null) {
            invoiceEntity = new InvoiceEntity();
        }
        final DateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.objectMapper.setDateFormat(dateFormat);
        updateEntity(invoice, invoiceEntity, this.objectMapper);
        final InvoiceEntity inv = this.repository.save(invoiceEntity);
        return this.toModel(inv);
    }

    private Invoice toModel(final InvoiceEntity en) {
        return Invoice.invoiceId(en.getName()).createdTime(en.getCreatedTime())
            .id(en.getId()).lastModifiedTime(en.getLastModifiedTime())
            .name(en.getGuestName());
    }

    @Autowired
    private ObjectMapper objectMapper;

    private static void updateEntity(
        final Invoice i,
        final InvoiceEntity en,
        final ObjectMapper objectMapper) throws JsonProcessingException {
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
