package com.rbenes.log4j2tryout;

import org.apache.logging.log4j.Logger;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SomeTool {

    @Getter
    int toolPrice;

    public SomeTool(int toolPrice) {
        this.toolPrice = toolPrice;
    }
    
    public void run() {
        log.info("This costed {}", toolPrice);
    }

    public void runWithCurrency(String currency) {
        log.info("This costed {} {}s", toolPrice, currency);
    }    

    public Logger getLog() {
        return log;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj instanceof SomeTool) {

            return this.toolPrice == ((SomeTool)obj).getToolPrice();
        }

        return false;
    }
}
