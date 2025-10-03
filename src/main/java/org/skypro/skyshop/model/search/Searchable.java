package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    // Метод получения search term
    public String getSeachTerm(String term);

    //Метод получения типа контента
    String getContentType();

    //Метод получения имени объекта
    String getProductName();

    public default String getStringRepresentation() {
        return "имя Searchable-объекта - тип Searhable-объекта";
    }

    public UUID getId();
}
