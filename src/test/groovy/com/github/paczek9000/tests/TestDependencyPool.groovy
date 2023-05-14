package com.github.paczek9000.tests

import com.github.paczek9000.infrastructure.TestApplicationContext
import com.github.paczek9000.infrastructure.TestProperties
import com.github.paczek9000.infrastructure.drivers.DriverManager
import com.github.paczek9000.infrastructure.profileresolver.SystemActivePropertyProfileResolver
import com.github.paczek9000.pages.DemoPage
import com.github.paczek9000.utils.selenium.UrlResolver
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@ActiveProfiles(value = ["dev", "chrome"], resolver = SystemActivePropertyProfileResolver.class)
@SpringBootTest(classes = TestApplicationContext.class)
class TestDependencyPool extends Specification {

    @Autowired
    protected TestProperties testProperties

    @Autowired
    protected DriverManager driverManager

    @Autowired
    protected WebDriver driver

    @Autowired
    protected UrlResolver urlResolver

    @Autowired
    protected DemoPage demoPage
}
