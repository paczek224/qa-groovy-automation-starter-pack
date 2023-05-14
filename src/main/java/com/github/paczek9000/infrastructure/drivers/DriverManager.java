package com.github.paczek9000.infrastructure.drivers;

import com.github.paczek9000.infrastructure.TestProperties;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DriverManager {
    protected WebDriver driver;

    @Autowired
    private TestProperties testProperties;

    public abstract void startService();

    public abstract void createDriver();

    public abstract void quitDriver();

    public WebDriver getDriver() {
        if (driver == null) {
            if (!testProperties.isGridOn()) {
                startService();
            }
            createDriver();
        }
        return driver;
    }
}
