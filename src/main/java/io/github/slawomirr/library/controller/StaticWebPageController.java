package io.github.slawomirr.library.controller;

import io.github.slawomirr.library.config.DatabaseConfiguration;
import io.github.slawomirr.library.config.WebSiteConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class StaticWebPageController {

    private WebSiteConfiguration webSite;
    private DatabaseConfiguration databaseUrl;

    public StaticWebPageController(WebSiteConfiguration webSite, DatabaseConfiguration databaseUrl) {
        this.webSite = webSite;
        this.databaseUrl = databaseUrl;
    }

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("url_info_documentation", (webSite.getWebSite() + "/swagger-ui.html"));
        model.put("url_link_documentation", (webSite.getWebSite() + "/swagger-ui.html"));
        model.put("url_info_h2", (webSite.getWebSite() + "/console"));
        model.put("url_link_h2", (webSite.getWebSite() + "/console"));
        model.put("h2_url_field_info", databaseUrl.getDatabaseUrl());
        model.put("isH2", databaseUrl.isH2());
        return "index";
    }
}
