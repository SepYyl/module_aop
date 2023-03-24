package com.example.sss.config;

/**
 * @className: com.sep.grafana.config.ThymeleafConfiguration
 * @author: sepY
 * @create: 2023-03-08 15:08
 * @description: Thymeleaf
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import javax.annotation.PostConstruct;

@Configuration
public class ThymeleafConfiguration {

    private TemplateEngine templateEngine;

    @Autowired
    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @PostConstruct
    public void init() {
        templateEngine.addTemplateResolver(new StringTemplateResolver());
    }
}