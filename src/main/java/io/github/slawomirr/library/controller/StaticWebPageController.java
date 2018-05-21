package io.github.slawomirr.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class StaticWebPageController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("url_info_documentation", "http://localhost:8085/swagger-ui.html");
        model.put("url_link_documentation", "http://localhost:8085/swagger-ui.html");
        model.put("url_info_h2", "http://localhost:8085/console");
        model.put("url_link_h2", "http://localhost:8085/console");
        model.put("h2_url_field_info", "jdbc:h2:mem:AZ");
        return "index";
    }
}
