package com.rbenes.log4j2tryout;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class AppTest {
    
    Marker MARKER = MarkerManager.getMarker("AppTestMarker");

    @Test
    public void shouldAnswerWithTrue() {
        log.info(MARKER, "AppTest logs");
        assertThat(1 + 1).isEqualTo(2);
    }
}
