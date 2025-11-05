package com.rbenes.log4j2tryout.appenders;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.rbenes.log4j2tryout.InMemAppender;
import com.rbenes.log4j2tryout.SomeTool;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InMemoryAppendersTest {

    @Test
    void customAppender() {

        SomeTool st = new SomeTool(50);

        Logger logger = (Logger)st.getLog();
        LoggerContext stContext = logger.getContext();
        Configuration config = stContext.getConfiguration();

        InMemAppender ima = new InMemAppender("test-ima");
        ima.start();

        config.addLoggerAppender(logger, ima);

        st.run();
        st.runWithCurrency("tolar");

        ima.stop();

        System.out.println(ima.getMessages());
    }
}