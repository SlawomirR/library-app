package io.github.slawomirr.library.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DatabaseConfiguration {

    @Value("${database.url.string}")
    private String databaseUrl;

    @Value("${database.isH2}")
    private boolean isH2;
}
