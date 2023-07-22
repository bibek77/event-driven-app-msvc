package com.github.bibek77.listener;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.StatusAdapter;

/**
 * @author bibek
 */
//@Slf4j
@Component
public class TwitterKafkaStatusListener extends StatusAdapter {

    public static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStatusListener.class);
    public void onStatus(Status status) {
        LOG.info("Twitter status with text {}", status.getText());
    }
}
