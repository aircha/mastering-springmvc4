package com.aircha.search.cache;

import com.aircha.search.LightTweet;
import com.aircha.search.SearchParamsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.social.TwitterProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchCache {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private Twitter twitter;

    @Autowired
    public SearchCache(TwitterProperties twitterProperties) {
        this.twitter = new TwitterTemplate(twitterProperties.getAppId(), twitterProperties.getAppSecret());
    }

    @Cacheable("searches")
    public List<LightTweet> fetch(String searchType, String keyword) {
        logger.info("Cache miss for : {}", keyword);
        SearchParameters searchParam = SearchParamsBuilder.createSearchParam(searchType, keyword);
        return twitter.searchOperations()
                .search(searchParam).getTweets().stream()
                .map(LightTweet::ofTweet)
                .collect(Collectors.toList());
    }
}
