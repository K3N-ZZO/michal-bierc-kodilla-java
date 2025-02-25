package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.hibernate.tasklist.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListname(){
        //Given
        TaskList taskList = new TaskList("Listname","Description");
        taskListDao.save(taskList);
        String description = taskList.getDescription();
        String listname = taskList.getListName();
        //When
        List<TaskList> readTaskList = taskListDao.findByListName(listname);
        //Then
        assertEquals(1, readTaskList.size());
        //CleanUp
        int id = readTaskList.get(0).getId();
        taskListDao.deleteById(id);

    }

}
