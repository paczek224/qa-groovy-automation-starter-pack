package com.github.paczek9000.infrastructure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "test")
public class TestProperties {
    private boolean gridOn;
    private Integer timeoutInSeconds;
    private Integer port;
    private String gridUrl;
    private String protocol;
    private String appFile;
    private String mockLoginUrl;
    private String host;
}
