package com.mphasis.main.se;

public class Stock {
    private String StockId;
    private String name;
    private int quantity;

    public String getStockId() {
        return StockId;
    }

    public void setStockId(String stockId) {
        StockId = stockId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public Stock(String stockId, String name, int quantity) {
        StockId = stockId;
        this.name = name;
        this.quantity = quantity;

    }
}
