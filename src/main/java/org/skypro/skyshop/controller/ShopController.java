package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ShopController {
    private final StorageService storageServ;
    private final SearchService searchServ;

    public ShopController(StorageService storageServ, SearchService searchServ) {
        this.storageServ = storageServ;
        this.searchServ = searchServ;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageServ.getProducts().values();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageServ.getArticles().values();
    }

    @GetMapping("/search")
    public Collection<SearchResult> findPattern(@RequestParam("pattern") String pattern) {
        return searchServ.search(pattern);
    }
}
