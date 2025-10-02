package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        products = initialProducts();
        articles = initialArticles();
    }

    public Map<UUID, Product> getProducts() {
        return products;
    }

    public Map<UUID, Article> getArticles() {
        return articles;
    }

    // initialization of products
    private Map<UUID, Product> initialProducts() {
        Map<UUID, Product> result = new HashMap<>();
        UUID uuId = UUID.randomUUID();
        result.put(uuId, new SimpleProduct("bananas", 5, uuId));
        uuId = UUID.randomUUID();
        result.put(uuId, new SimpleProduct("bananas", 7, uuId));
        uuId = UUID.randomUUID();
        result.put(uuId, new FixPriceProduct("apples", uuId));
        uuId = UUID.randomUUID();
        result.put(uuId, new DiscountedProduct("pears", 2, 50, uuId));
        uuId = UUID.randomUUID();
        result.put(uuId, new SimpleProduct("lemons", 7, uuId));
        uuId = UUID.randomUUID();
        result.put(uuId, new DiscountedProduct("eggs", 10, 20, uuId));
        return result;
    }

    // initialization of articles
    private Map<UUID, Article> initialArticles() {
        Map<UUID, Article> result = new HashMap<>();
        UUID uuId = UUID.randomUUID();
        result.put(uuId, new Article("apples", "сочный плод яблони, который употребляется в пищу в свежем и" +
                " запечённом виде, служит сырьём в кулинарии и для приготовления напитков." +
                "test test testtest", uuId));
        uuId = UUID.randomUUID();
        result.put(uuId, new Article("pineap", "The pineapple is indigenous to South America," +
                " where it has been cultivated for many centuries.test", uuId));
        uuId = UUID.randomUUID();
        result.put(uuId, new Article("bananas", "Бананы — одна из древнейших пищевых культур, а для тропических" +
                " стран — важнейшее пищевое растение и главная статья экспорта.test", uuId));
        return result;
    }

    public List<Searchable> getSearchabls() {
        return Stream.concat(
                getProducts().values().stream().map((p) -> (Searchable) p),
                getArticles().values().stream().map((a) -> (Searchable) a)
        ).collect(Collectors.toList());
    }
}
