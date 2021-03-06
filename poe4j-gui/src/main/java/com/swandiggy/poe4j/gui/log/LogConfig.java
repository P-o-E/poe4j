package com.swandiggy.poe4j.gui.log;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.ext.spring.ApplicationContextHolder;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jacob Swanson
 * @since 12/11/2015
 */
@Configuration
public class LogConfig {

    @Bean
    public ApplicationContextHolder applicationContextHolder() {
        return new ApplicationContextHolder();
    }

    @Bean
    public static LoggerContext loggerContext() {
        return (LoggerContext) LoggerFactory.getILoggerFactory();
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public ObservableLogAppender logAppender(LoggerContext loggerContext) {
        ObservableLogAppender appender = new ObservableLogAppender();
        appender.setContext(loggerContext);

        return appender;
    }
}
