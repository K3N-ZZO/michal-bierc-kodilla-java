package com.kodilla.spring.intro.shape;

import com.kodilla.spring.intro.Drawer;
import org.junit.jupiter.api.Test;

public class DrawerTestSuite {

    @Test
    void testDoDrawing() {
        //Given
        Drawer drawer = new Drawer();

        //When
        drawer.doDrawing();

        //Then
        //do nothing
    }
}
