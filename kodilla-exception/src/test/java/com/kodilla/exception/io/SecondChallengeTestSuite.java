package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {
    @Test
    public void testPropablyIWillThrowException(){
        //Given
        SecondChallenge sc = new SecondChallenge();
        //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> sc.propablyIWillThrowException(2.0,1.0)),
                () -> assertThrows(Exception.class, () -> sc.propablyIWillThrowException(0.5,1.0)),
                () ->assertThrows(Exception.class, () -> sc.propablyIWillThrowException(1.5,1.5)),
                () -> assertDoesNotThrow(()->sc.propablyIWillThrowException(1.5,1.0)),

                () -> assertThrows(Exception.class, () -> sc.propablyIWillThrowException(1.0,1.5)),
                () -> assertDoesNotThrow(()->sc.propablyIWillThrowException(1.0,1.0))
            );
    }
}
