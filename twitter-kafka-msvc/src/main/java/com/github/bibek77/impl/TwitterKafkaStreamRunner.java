package com.github.bibek77.impl;

import com.github.bibek77.config.TwitterToKafkaServiceConfig;
import com.github.bibek77.listener.TwitterKafkaStatusListener;
import com.github.bibek77.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PreDestroy;
import java.util.Arrays;

/**
 * @author bibek
 */
@Component
public class TwitterKafkaStreamRunner implements StreamRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStreamRunner.class);
    private final TwitterKafkaStatusListener twitterKafkaStatusListener;

    private final TwitterToKafkaServiceConfig twitterToKafkaServiceConfig;

    private TwitterStream twitterStream;

    public TwitterKafkaStreamRunner(TwitterKafkaStatusListener twitterKafkaStatusListener, TwitterToKafkaServiceConfig twitterToKafkaServiceConfig) {
        this.twitterKafkaStatusListener = twitterKafkaStatusListener;
        this.twitterToKafkaServiceConfig = twitterToKafkaServiceConfig;
    }


    @Override
    public void start() throws TwitterException {
        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterKafkaStatusListener);
        addFilter();
    }

    @PreDestroy
    public void shutDown() {
        if (twitterStream != null) {

            LOG.info("Closing twitter stream");
            twitterStream.shutdown();
        }
    }

    private void addFilter() {
        String[] keywords = twitterToKafkaServiceConfig.getTwitterKeywords().toArray(new String[0]);
        FilterQuery filterQuery = new FilterQuery(keywords);
        twitterStream.filter(filterQuery);
        LOG.info("Started Filtering twitter stream for keywords : {}", Arrays.toString(keywords));
    }

}
