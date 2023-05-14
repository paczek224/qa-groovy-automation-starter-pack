package com.github.paczek9000.tests

import com.github.paczek9000.infrastructure.drivers.ChromeDriverManager
import org.awaitility.Awaitility
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import java.time.Duration

class BaseTest extends TestDependencyPool {

    private static final Logger testLogger = LoggerFactory.getLogger(ChromeDriverManager.class)


    def setup() {

        Awaitility.setDefaultTimeout(Duration.ofSeconds(testProperties.timeoutInSeconds))
        Awaitility.ignoreExceptionsByDefault()
    }

   def cleanup() {

        testLogger.info("Tearing down test...")

        driverManager.quitDriver()
    }
}
