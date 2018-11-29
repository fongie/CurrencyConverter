package se.kth.korlinge.currencyconverter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableTransactionManagement
//@EnableWebMvc //this class can create stuff handling web requests, view resolving, etc
@Configuration
public class Config {
}
