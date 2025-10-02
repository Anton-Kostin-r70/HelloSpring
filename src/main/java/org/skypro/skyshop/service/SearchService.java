package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageServ;

    public SearchService(StorageService storageServ) {
        this.storageServ = storageServ;
    }

    public List<SearchResult> search(String term) {
        return storageServ.getSearchabls().stream()
                .filter((s) -> (s.getSeachTerm(term).contains(term)))
                .map(SearchResult::fromSearchable).collect(Collectors.toList());
    }

}
