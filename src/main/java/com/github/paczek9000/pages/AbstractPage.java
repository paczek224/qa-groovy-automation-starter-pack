package com.github.paczek9000.pages;

import com.github.paczek9000.utils.selenium.UrlResolver;
import com.github.paczek9000.utils.selenium.WebElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractPage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected UrlResolver urlResolver;

    @Autowired
    protected WebElementUtil webElementUtil;

    protected void initPage(){
        PageFactory.initElements(driver, this);
    }
}
