package com.github.paczek9000.infrastructure.drivers;


import com.github.paczek9000.infrastructure.TestProperties;
import lombok.SneakyThrows;
import lombok.val;
import org.awaitility.Durations;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.nio.file.Paths;
import java.time.Duration;

public class ChromeDriverManager extends DriverManager {

    @Autowired
    public TestProperties testProperties;
    private ChromeDriverService chromeDriverService;
    private static final Logger logger = LoggerFactory.getLogger(ChromeDriverManager.class);

    @Override
    public void startService() {

        try {

            val path = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
            val chromeDriverPath = Paths.get(path);

            logger.info("Starting Chrome driver service...\nexe path {}", path);

            chromeDriverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(chromeDriverPath.toFile())
                    .usingAnyFreePort()
                    .build();

            chromeDriverService.start();

        } catch (Exception err) {
            logger.error(err.getMessage());
        }
    }

    @Override
    @SneakyThrows
    public void createDriver() {
        logger.info("Creating Chrome driver ...");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("IntensiveWakeUpThrottlingEnabled=1");

        if (testProperties.isGridOn()) {
            val toURL = new URI(testProperties.getGridUrl()).toURL();
            driver = new RemoteWebDriver(toURL, options);
        } else {
            driver = new ChromeDriver(chromeDriverService, options);
        }

        driver.manage()
                .timeouts()
                .scriptTimeout(Duration.ofSeconds(testProperties.getTimeoutInSeconds()))
                .implicitlyWait(Durations.ONE_SECOND);
    }

    @Override
    @SneakyThrows
    public void quitDriver() {
        logger.info("Stopping Chrome driver ...");
        getDriver().close();
        getDriver().quit();

        Thread.sleep(500);

        if (chromeDriverService != null && chromeDriverService.isRunning()) {
            logger.info("Stopping the driver service");

            chromeDriverService.close();
        }
    }
}
