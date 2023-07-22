package com.github.bibek77.runner;

import twitter4j.TwitterException;

/**
 * @author bibek
 */
public interface StreamRunner {
    void start() throws TwitterException;
}
