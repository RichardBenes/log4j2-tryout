package com.rbenes.log4j2tryout.instances;

import java.net.URI;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

import com.rbenes.log4j2tryout.SomeTool;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAndSomeToolTest {

    @BeforeEach
    void beforeEach(TestInfo ti) {
        System.out.println("--- " + ti.getTestMethod().get().getName());
    }

    @AfterEach
    void afterEach() {
        System.out.println();
    }

    @Test
    @Order(0)
    void objectInstanceEquality() {

        var someTool1 = new SomeTool(10);
        var someTool2 = new SomeTool(10);

        System.out.println("Instance equality: " + (someTool1 == someTool2));
        System.out.println("equals(): " + someTool1.equals(someTool2));
    }

    @Test
    @Order(1)
    void isThereASingleRootLogger() {

        var lcRootLogger = LoggerContext.getContext().getRootLogger();

        var st = new SomeTool(50);
        var stRootLogger = ((Logger)st.getLog()).getContext().getRootLogger();

        System.out.println("lcRootLogger: " + lcRootLogger);
        System.out.println("stRootLogger: " + stRootLogger);          
        System.out.println("They're the same instance: "
            + (lcRootLogger == stRootLogger));
    }

    @Test
    @Order(2)
    void isThereASingleLoggerContext() {

        LoggerContext lcCtx = LoggerContext.getContext();

        SomeTool st = new SomeTool(50);
        LoggerContext stCtx = ((Logger)st.getLog()).getContext();

        System.out.println("lcCtx: " + lcCtx);
        System.out.println("stCtx: " + stCtx);        
        System.out.println("They're the same instance: "
            + (lcCtx == stCtx));
    }

    @Test
    @Order(3)
    void isThereASingleConfig() {

        Configuration lcCfg = LoggerContext.getContext().getConfiguration();

        SomeTool st = new SomeTool(50);
        Configuration stCfg = ((Logger)st.getLog()).getContext().getConfiguration();

        System.out.println("lcCfg: " + lcCfg);
        System.out.println("stCfg: " + stCfg);
        System.out.println("They're the same instance: "
            + (lcCfg == stCfg));
        
        // LoggerContext can be obtained from Configuration...
    }

    @Test
    @Order(4)
    void isThereASingleConfigLocation() {

        URI lcCfgLoc = LoggerContext.getContext().getConfigLocation();

        SomeTool st = new SomeTool(50);
        URI stCfgLoc = ((Logger)st.getLog()).getContext().getConfigLocation();

        System.out.println("lcCfgLoc: " + lcCfgLoc);
        System.out.println("stCfgLoc: " + stCfgLoc);
        System.out.println("They're the same instance: "
            + (lcCfgLoc == stCfgLoc));
    }
}
