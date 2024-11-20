package com.kodilla.spring;

import com.kodilla.spring.portfolio.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PortfolioTestSuite {
    @Autowired
    private Board board;

    @Test
    void testTaskAdd(){
        //Given
        //When
        board.getToDoList().getTasks().add("Task to do");
        board.getInProgressList().getTasks().add("Task in progress");
        board.getCompletedList().getTasks().add("Completed task");
        //Then
        assertEquals("Task to do", board.getToDoList().getTasks().get(0));
        assertEquals("Task in progress",board.getInProgressList().getTasks().get(0));
        assertEquals("Completed task",board.getCompletedList().getTasks().get(0));
    }
}
