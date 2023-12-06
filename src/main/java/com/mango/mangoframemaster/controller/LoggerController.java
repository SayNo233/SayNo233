package com.mango.mangoframemaster.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {
    // 1. 得到日志对象
    private Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping("/logger")
    public String logger() {
        // 2. 日志打印
        logger.trace("日志级别: trace");
        logger.debug("日志级别: debug");
        logger.info("日志级别: info");
        logger.warn("日志级别: warn");
        logger.error("日志级别: error");
        return "logger";
    }
}

