package com.github.paczek9000.configuration;

import com.github.paczek9000.infrastructure.TestProperties;
import com.github.paczek9000.infrastructure.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DriverManagerConfiguration.class, TestProperties.class})
public class DriverConfiguration {

    @Autowired
    DriverManager driverManager;

    @Bean
    public WebDriver getDriver()  {
        return driverManager.getDriver();
    }
}
