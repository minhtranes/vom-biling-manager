/*
 * Class: Item
 *
 * Created on Nov 14, 2020
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.minhtran.vom.vbm.model;

public class Item {
    
    private int itemOrder;
    private String itemName;
    private int itemUnitPrice;
    private int itemQuantity;
    private int itemAmount;
    public int getItemOrder() {
        return itemOrder;
    }
    public void setItemOrder(int itemOrder) {
        this.itemOrder = itemOrder;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemUnitPrice() {
        return itemUnitPrice;
    }
    public void setItemUnitPrice(int itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }
    public int getItemQuantity() {
        return itemQuantity;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    public int getItemAmount() {
        return itemAmount;
    }
    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }
}
