package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private int price;
    private static final String SIMPLE_PRODUCT = "SIMPLE_PRODUCT";

    public SimpleProduct(String title, int price, UUID id) {
        super(title, id);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена на товар не может быть отрицательной или равной нулю");
        }
        this.price = price;
        product = SIMPLE_PRODUCT;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getTitle() + ":\t" + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
