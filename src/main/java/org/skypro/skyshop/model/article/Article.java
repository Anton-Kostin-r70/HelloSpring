package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable, Comparable<Searchable> {
    private String title;
    private String description;
    private static final String ARTICLE = "ARTICLE";
    private final UUID id;

    public Article(String title, String description, UUID id) {
        if (title == null || title.trim().length() == 0 || description == null || description.trim().length() == 0
                || id.toString().isEmpty()) {
            throw new IllegalArgumentException("Проверьте вносимые сведения в описании");
        }
        if (id == null || id.toString().isEmpty()) {
            throw new IllegalArgumentException("Проверьте генератор Id");
        }
        this.title = title;
        this.description = description;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + ": " + description;
    }

    // Метод получения search term
    @JsonIgnore
    public String getSeachTerm(String term) {
        return toString().replace('\n', '\s') + " - " + ARTICLE;
    }

    //Метод получения типа контента
    @JsonIgnore
    public String getContentType() {
        return ARTICLE;
    }

    //Метод получения имени объекта
    public String getProductName() {
        return getTitle();
    }

    public String getStringRepresentation() {
        return getTitle() + " - " + ARTICLE;
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