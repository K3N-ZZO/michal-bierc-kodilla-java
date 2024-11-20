package com.kodilla.spring.portfolio;

import org.springframework.stereotype.Component;

@Component
public class Board {
    TaskList toDoList;
    TaskList inProgressList;
    TaskList completedList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList completedList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.completedList = completedList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getCompletedList() {
        return completedList;
    }
}
