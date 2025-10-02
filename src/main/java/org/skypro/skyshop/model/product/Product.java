package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable, Comparable<Searchable> {
    private String title;
    private final UUID id;
    protected String product = "PRODUCT";

    public abstract boolean isSpecial();

    public Product(String title, UUID id) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Вносимые сведения о товаре не корректны");
        }
        if (id == null || id.toString().isEmpty()) {
            throw new IllegalArgumentException("Проверьте генератор Id");
        }
        this.title = title.trim();
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    @JsonIgnore
    public String getSeachTerm(String term) {
        return title;
    }

    @JsonIgnore
    public String getContentType() {
        return product;
    }

    public String getProductName() {
        return getTitle();
    }

    public String getStringRepresentation() {
        return this != null ? getTitle() + " - " + product : "";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Searchable)) {
            return false;
        }
        return Objects.equals(title, getProductName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public int compareTo(Searchable o) {
        return o.getProductName().length() - this.getProductName().length();
    }

    @Override
    public UUID getId() {
        return this.id;
    }
}
