package com.github.paczek9000.utils.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.collections.CollectionUtils;

import java.util.List;

import static org.awaitility.Awaitility.await;

@Component
public class WebElementUtil {
    @Autowired
    WebDriver driver;

    public void waitForElementDisplayed(WebElement element) {

        await(String.format("Waiting for element to be displayed element:<%s>", element))
                .until(element::isDisplayed);
    }

    public void waitForNotEmpty(List<WebElement> elements) {

        await(String.format("Waiting list to not be empty elements:<%s>", elements))
                .until(()-> CollectionUtils.hasElements(elements));
    }
}
