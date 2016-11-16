package com.aircha.search;

import java.util.List;
import java.util.stream.Collectors;

import com.aircha.search.cache.SearchCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile({"!async", "!test"})
public class SearchService implements TwitterSearch {

    private SearchCache searchCache;

    @Autowired
    public void setSearchCache(SearchCache searchCache) {
        this.searchCache = searchCache;
    }

    @Override
    public List<LightTweet> search(String searchType, List<String> keywords) {
        return keywords.stream().flatMap(keyword -> searchCache.fetch(searchType, keyword).stream())
                .collect(Collectors.toList());
    }
}
