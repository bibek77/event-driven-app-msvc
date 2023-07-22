package com.github.bibek77;

import com.github.bibek77.config.TwitterToKafkaServiceConfig;
import com.github.bibek77.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * @author ${USER}
 */
@SpringBootApplication
public class TwitterToKafkaService implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaService.class);
    private final TwitterToKafkaServiceConfig twitterToKafkaServiceConfig;

    private final StreamRunner streamRunner;

//    @Autowired
//    private TwitterToKafkaServiceConfig twitterToKafkaServiceConfig;

    public TwitterToKafkaService(TwitterToKafkaServiceConfig configData, StreamRunner streamRunner) {
        this.twitterToKafkaServiceConfig = configData;
        this.streamRunner = streamRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaService.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Application has stated !!!");
        LOG.info(Arrays.toString(twitterToKafkaServiceConfig.getTwitterKeywords().toArray(new String[]{})));
        LOG.info(twitterToKafkaServiceConfig.getWelcomeMessage());
        streamRunner.start();
    }

}