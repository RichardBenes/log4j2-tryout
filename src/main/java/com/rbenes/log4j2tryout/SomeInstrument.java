package com.rbenes.log4j2tryout;

import org.apache.logging.log4j.Logger;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SomeInstrument {

    @Getter
    int instrPrice;

    public SomeInstrument(int instrumentPrice) {
        this.instrPrice = instrumentPrice;
    }
    
    public void run() {
        log.info("This costed {}", instrPrice);
    }

    public Logger getLog() {
        return log;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj instanceof SomeInstrument) {

            return this.instrPrice == ((SomeInstrument)obj).getInstrPrice();
        }

        return false;
    }
}
