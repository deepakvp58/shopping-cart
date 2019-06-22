package shop;

import java.io.Serializable;
import java.io.*;
import java.util.*;
public class Items implements Serializable {

    private String iname;
    private int quantity;
    private int price;

    public void setIname(String iname) {

        this.iname = iname;
    }

    public String getIname() {
        return this.iname;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
