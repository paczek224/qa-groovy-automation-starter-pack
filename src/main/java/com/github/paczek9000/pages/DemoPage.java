package com.github.paczek9000.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Getter
@Component
public class DemoPage extends AbstractPage {
    @FindBy(xpath = "//h1[.='Tools and Taverns']")
    private WebElement title;

    @PostConstruct
    public void initElements() {
        initPage();
    }

    public void goTo() {
        driver.get(urlResolver.getAppUrl());
    }
}
