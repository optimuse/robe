package io.robe.mail;

import com.yammer.dropwizard.ConfiguredBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;
import org.slf4j.Logger;

/**
 * Bundle class for mail implementation.
 */
public class MailBundle<T extends Configuration & HasMailConfiguration> implements ConfiguredBundle<T> {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MailBundle.class);

    private static MailSender mailSender = null;

    public static boolean isIsActive() {
        return isActive;
    }

    private static boolean isActive = false;


    /**
     * Initializes the environment.
     *
     * @param configuration the configuration object
     * @param environment   the io.robe.admin's {@link com.yammer.dropwizard.config.Environment}
     * @throws Exception if something goes wrong
     */
    @Override
    public void run(T configuration, Environment environment) throws Exception {
        if (configuration.getMailConfiguration() != null) {
            mailSender = new MailSender(configuration.getMailConfiguration());
            isActive = true;
        } else {
            LOGGER.warn("Bundle included but no configuration (mail) found at yml.");
            isActive = false;
        }
    }

    /**
     * Initializes the io.robe.admin bootstrap.
     *
     * @param bootstrap the io.robe.admin bootstrap
     */
    @Override
    public void initialize(Bootstrap<?> bootstrap) {
        LOGGER.info("Initializing MailBundle");
    }

    public static MailSender getMailSender() {
        return mailSender;
    }
}
