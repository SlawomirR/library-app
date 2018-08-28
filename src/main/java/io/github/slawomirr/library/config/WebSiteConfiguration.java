package io.github.slawomirr.library.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class WebSiteConfiguration {

    @Value("${website.url}")
    private String webSite;
}
