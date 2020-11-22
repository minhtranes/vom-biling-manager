/*
 * Class: SaveInvoiceResponse
 *
 * Created on Nov 22, 2020
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

public class SaveInvoiceResponse {
    private int id;

    private LocalDateTime lastModifiedTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
    
    private SaveInvoiceResponse() {
    }
    
    public static SaveInvoiceResponse from(Invoice i) {
        final SaveInvoiceResponse si = new SaveInvoiceResponse();
        {
            si.setId(i.getId());
            si.setLastModifiedTime(i.getLastModifiedTime());
        }
        return si;
    }
}
