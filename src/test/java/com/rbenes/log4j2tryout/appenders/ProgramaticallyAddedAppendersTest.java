package com.rbenes.log4j2tryout.appenders;

import java.io.ByteArrayOutputStream;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.OutputStreamAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

import com.rbenes.log4j2tryout.InMemAppender;
import com.rbenes.log4j2tryout.SomeTool;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProgramaticallyAddedAppendersTest {

    static final String ADDED_APPENDER_NAME = "added-appender";

    SomeTool st;
    Logger logger;
    LoggerContext loggerContext;
    Configuration configuration;

    @BeforeEach
    void beforeEach(TestInfo ti) {
        System.out.println("--- " + ti.getTestMethod().get().getName());

        st = new SomeTool(50);
        logger = (Logger)st.getLog();
        loggerContext = logger.getContext();
        configuration = loggerContext.getConfiguration();
    }

    @AfterEach
    void afterEach() {

        configuration.getAppenders().remove(ADDED_APPENDER_NAME);
        loggerContext.reconfigure();
    }

    @Test
    @Order(0)
    void customAppender() {

        InMemAppender ima = new InMemAppender(ADDED_APPENDER_NAME);
        ima.start();

        configuration.addLoggerAppender(logger, ima);

        st.run();
        st.runWithCurrency("tolar");

        ima.stop();

        System.out.println(ima.getMessages());
    }

    @Test
    @Order(1)
    void outputStreamAppender() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        OutputStreamAppender osa = 
            OutputStreamAppender.newBuilder()
                .setName(ADDED_APPENDER_NAME)
                .setTarget(baos)
                .build();

        configuration.addLoggerAppender(logger, osa);

        osa.start();

        st.run();
        st.runWithCurrency("shekel");

        osa.stop();

        System.out.println(baos.toString());
    }
}