package com.example.sss.config;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: com.sep.grafana.config.ProxyConfiguration
 * @author: sepY
 * @create: 2023-03-08 15:42
 * @description: TODO
 */
@Configuration
public class ProxyConfiguration {
    @Value("${proxy.grafana.servlet_url}")
    private String servletUrl;

    @Value("${proxy.grafana.target_url}")
    private String targetUrl;

    @Value("${proxy.grafana.key}")
    private String key;

    @Bean
    public ServletRegistrationBean<Servlet> proxyServletRegistration() {
        // 设置需要反向代理的url
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(getServlet(), servletUrl);
        Map<String, String> params = new HashMap<>();
        params.put("targetUri", targetUrl);
        //如果需要打印日志，将值设置为true
        params.put("log", "false");
        registrationBean.setInitParameters(params);
        return registrationBean;
    }

    public Servlet getServlet() {
        return new ProxyServlet() {
            @Override
            protected HttpResponse doExecute(HttpServletRequest servletRequest, HttpServletResponse servletResponse,
                                             HttpRequest proxyRequest) throws IOException {
                // 可以在这之前执行一些其他操作，比如鉴权等...

                // 设置Authorization请求头，值为Grafana中创建的api key值
                proxyRequest.setHeader("Authorization", key);
                return super.doExecute(servletRequest, servletResponse, proxyRequest);
            }
        };
    }
}
