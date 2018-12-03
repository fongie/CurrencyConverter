package se.kth.korlinge.currencyconverter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Config class for the spring application. Defaults were sufficient for everything except to enable transaction management.
 */
@EnableTransactionManagement //needed to use transactional in other classes
@Configuration
public class Config {
}
