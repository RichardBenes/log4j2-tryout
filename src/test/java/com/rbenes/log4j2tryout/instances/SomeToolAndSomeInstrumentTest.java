package com.rbenes.log4j2tryout.instances;

import java.net.URI;

import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.rbenes.log4j2tryout.SomeInstrument;
import com.rbenes.log4j2tryout.SomeTool;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SomeToolAndSomeInstrumentTest {

    @Test
    @Order(0)
    void objectInstanceEquality() {

        System.out.println("--- objectInstanceEquality");

        var someTool = new SomeTool(10);
        var someInstrument = new SomeInstrument(10);

        // System.out.println("Instance equality: " + (someTool == someInstrument));
        System.out.println("equals(): " + someTool.equals(someInstrument));
    }

    @Test
    @Order(1)
    void isThereASingleRootLogger() {

        System.out.println("--- isThereASingleRootLogger");

        var st = new SomeTool(50);
        var si = new SomeInstrument(50);

        var stRootLogger = ((Logger)st.getLog()).getContext().getRootLogger();
        var siRootLogger = ((Logger)si.getLog()).getContext().getRootLogger();

        System.out.println("stRootLogger: " + stRootLogger);
        System.out.println("siRootLogger: " + siRootLogger);          
        System.out.println("They're the same instance: "
            + (stRootLogger == siRootLogger));
    }

    @Test
    @Order(2)
    void isThereASingleLoggerContext() {

        System.out.println("--- isThereASingleLoggerContext");

        var st = new SomeTool(50);
        var si = new SomeTool(50);

        LoggerContext stCtx = ((Logger)st.getLog()).getContext();
        LoggerContext siCtx = ((Logger)si.getLog()).getContext();

        System.out.println("stCtx: " + stCtx);
        System.out.println("siCtx: " + siCtx);        
        System.out.println("They're the same instance: "
            + (stCtx == siCtx));
    }

    @Test
    @Order(3)
    void isThereASingleConfig() {

        System.out.println("--- isThereASingleConfig");

        var st = new SomeTool(50);
        var si = new SomeInstrument(50);

        Configuration stCfg = ((Logger)st.getLog()).getContext().getConfiguration();
        Configuration siCfg = ((Logger)si.getLog()).getContext().getConfiguration();

        System.out.println("stCfg: " + stCfg);
        System.out.println("siCfg: " + siCfg);
        System.out.println("They're the same instance: "
            + (stCfg == siCfg));
        
        // LoggerContext can be obtained from Configuration...
    }

    @Test
    @Order(4)
    void isThereASingleConfigLocation() {

        System.out.println("--- isThereASingleConfigLocation");

        var st = new SomeTool(50);
        var si = new SomeInstrument(50);

        URI stCfgLoc = ((Logger)st.getLog()).getContext().getConfigLocation();
        URI siCfgLoc = ((Logger)si.getLog()).getContext().getConfigLocation();

        System.out.println("stCfgLoc: " + stCfgLoc);
        System.out.println("siCfgLoc: " + siCfgLoc);
        System.out.println("They're the same instance: "
            + (stCfgLoc == siCfgLoc));
    }
}
