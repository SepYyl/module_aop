package com.example.sss.controller;

/**
 * @className: com.sep.grafana.controller.GrafanaController
 * @author: sepY
 * @create: 2023-03-08 15:09
 * @description: TODO
 */

import cn.ac.iie.cloud.iie.logs.aop.annotation.OperLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RestController
@RequestMapping("/grafanas")
public class GrafanaController {

    @GetMapping("/grafanaPage")
    @OperLog(operDesc = "系统设备管理界面展示一条信息")
    public String grafanaPage(@RequestParam Map<String, Object> params) {
        return "grafanas";
    }
}