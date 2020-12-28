/*
 * Class: Invoice
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
package vn.minhtran.vom.vbm.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Invoice {

    private int id;

    public int getId() {
        return id;
    }

    public Invoice id(int id) {
        this.id = id;
        return this;
    }

    private String invoiceId;

    private String sheetName;

    private String name;

    private String country;

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getSheetName() {
        return sheetName;
    }

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime checkInDate;

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime checkOutDate;

    private Integer totalAmount;

    private Integer paidAmount;

    private Integer remainAmount;

    @JsonSetter(value = "link")
    private String pdfLink;

    private LocalDateTime createdTime;

    private LocalDateTime lastModifiedTime;

    private Item[] items;

    public Item[] getItems() {
        return items;
    }

    public Invoice items(Item[] items) {
        this.items = items;
        return this;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public String getCountry() {
        return country;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public Integer getRemainAmount() {
        return remainAmount;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    private Invoice() {

    }

    public static Invoice invoiceId(String invoiceId) {
        final Invoice invoice = new Invoice();
        invoice.invoiceId = invoiceId;
        return invoice;
    }

    public Invoice name(String name) {
        this.name = name;
        return this;
    }

    public Invoice checkInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
        return this;
    }

    public Invoice checkOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
        return this;
    }

    public Invoice country(String country) {
        this.country = country;
        return this;
    }

    public Invoice totalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Invoice paidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
        return this;
    }

    public Invoice remainAmount(Integer remainAmount) {
        this.remainAmount = remainAmount;
        return this;
    }

    public Invoice pdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
        return this;
    }

    public Invoice createdTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Invoice createdTime(String createdTime) {
        this.createdTime = LocalDateTime.parse(createdTime);
        return this;
    }

    public Invoice lastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
        return this;
    }
    
    public Invoice lastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = LocalDateTime.parse(lastModifiedTime);
        return this;
    }

}
