package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE_PRODUCT = 50;
    private static final String FIX_PRICE_PRODUCT_STR = "FIX_PRICE_PRODUCT";

    public FixPriceProduct(String title, UUID id) {
        super(title, id);
        product = FIX_PRICE_PRODUCT_STR;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        return getTitle() + ": Фиксированная цена\t" + FIX_PRICE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
