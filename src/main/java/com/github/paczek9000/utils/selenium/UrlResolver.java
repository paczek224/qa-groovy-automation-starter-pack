package com.github.paczek9000.utils.selenium;

import com.github.paczek9000.infrastructure.TestProperties;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class UrlResolver {

    @Autowired
    TestProperties testProperties;

    @SneakyThrows
    public String getAppUrl() {
        return new URI(testProperties.getProtocol() + "://www." + testProperties.getHost() + ":" + testProperties.getPort() + "/")
                .toURL()
                .toString();
    }
}
