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

public class Invoice {

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

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private Integer totalAmount;

    private Integer paidAmount;

    private Integer remainAmount;

    private String pdfLink;

    private LocalDateTime createdTime;

    private LocalDateTime lastModifiedTime;
    
    private String[] items;
    
    public String[] getItems() {
        return items;
    }
    
    public Invoice items(String[] items) {
        this.items=items;
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

    public Invoice lastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
        return this;
    }

}
