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
public class TwoSomeToolsTest {

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

        var st1 = new SomeTool(50);
        var st2 = new SomeTool(50);

        var rootLogger1 = ((Logger)st1.getLog()).getContext().getRootLogger();
        var rootLogger2 = ((Logger)st2.getLog()).getContext().getRootLogger();

        System.out.println("rootLogger1: " + rootLogger1);
        System.out.println("rootLogger2: " + rootLogger2);          
        System.out.println("They're the same instance: "
            + (rootLogger1 == rootLogger2));
    }

    @Test
    @Order(2)
    void isThereASingleLoggerContext() {

        var st1 = new SomeTool(50);
        var st2 = new SomeTool(50);

        LoggerContext st1Ctx = ((Logger)st1.getLog()).getContext();
        LoggerContext st2Ctx = ((Logger)st2.getLog()).getContext();

        System.out.println("st1Ctx: " + st1Ctx);
        System.out.println("st2Ctx: " + st2Ctx);        
        System.out.println("They're the same instance: "
            + (st1Ctx == st2Ctx));
    }

    @Test
    @Order(3)
    void isThereASingleConfig() {

        var st1 = new SomeTool(50);
        var st2 = new SomeTool(50);

        Configuration st1Cfg = ((Logger)st1.getLog()).getContext().getConfiguration();
        Configuration st2Cfg = ((Logger)st2.getLog()).getContext().getConfiguration();

        System.out.println("st1Cfg: " + st1Cfg);
        System.out.println("st2Cfg: " + st2Cfg);
        System.out.println("They're the same instance: "
            + (st1Cfg == st2Cfg));
        
        // LoggerContext can be obtained from Configuration...
    }

    @Test
    @Order(4)
    void isThereASingleConfigLocation() {

        var st1 = new SomeTool(50);
        var st2 = new SomeTool(50);

        URI st1CfgLoc = ((Logger)st1.getLog()).getContext().getConfigLocation();
        URI st2CfgLoc = ((Logger)st2.getLog()).getContext().getConfigLocation();

        System.out.println("st1CfgLoc: " + st1CfgLoc);
        System.out.println("st2CfgLoc: " + st2CfgLoc);
        System.out.println("They're the same instance: "
            + (st1CfgLoc == st2CfgLoc));
    }
}
