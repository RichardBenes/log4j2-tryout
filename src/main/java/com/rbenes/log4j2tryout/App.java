package com.rbenes.log4j2tryout;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class App {

    final static Marker MAIN = MarkerManager.getMarker("MAIN");

    public static void main(String[] args) {
        
        log.info(MAIN, "Hi there");
    }
}
