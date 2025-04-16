package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkObserverTestSuite {

    @Test
    void testMentorGetsNotifiedAboutNewHomework() {
        // Given
        HomeworkSent student1Queue = new HomeworkSent("Adam Kowalski");
        HomeworkSent student2Queue = new HomeworkSent("Anna Nowak");

        HomeworkMentor mentor1 = new HomeworkMentor("Mentor Paweł");
        HomeworkMentor mentor2 = new HomeworkMentor("Mentor Ola");

        student1Queue.addObserver(mentor1);
        student2Queue.addObserver(mentor1);
        student2Queue.addObserver(mentor2);
        // When
        student1Queue.addHomework("Zadanie 1 - Stream API");
        student2Queue.addHomework("Zadanie 1 - Lambdy");
        student2Queue.addHomework("Zadanie 2 - Optional");
        // Then
        assertEquals(3, mentor1.getUpdateCount());
        assertEquals(2, mentor2.getUpdateCount());
    }

    @Test
    void testMentorReceivesCorrectNumberOfUpdatesFromOneStudent() {
        // Given
        HomeworkSent studentQueue = new HomeworkSent("Marek Testowy");
        HomeworkMentor mentor = new HomeworkMentor("Mentor Jacek");

        studentQueue.addObserver(mentor);

        // When
        studentQueue.addHomework("Zadanie 1 - JPA");
        studentQueue.addHomework("Zadanie 2 - Hibernate");
        studentQueue.addHomework("Zadanie 3 - Spring AOP");

        // Then
        assertEquals(3, mentor.getUpdateCount());
    }
}
