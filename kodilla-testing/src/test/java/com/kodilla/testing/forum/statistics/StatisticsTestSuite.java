package com.kodilla.testing.forum.statistics;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.when;

public class StatisticsTestSuite {
    private Statistics statisticsMock;
    private ForumStatisticsCounter forumStatisticsCounter;

    @BeforeEach
    void setUp() {
        statisticsMock = Mockito.mock(Statistics.class);
        forumStatisticsCounter = new ForumStatisticsCounter();
    }


    @Test
    void testStatisticsWithZeroPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(Arrays.asList("User1", "User2"));
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatisticsCounter.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfPosts);
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfComments);
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfCommentsPerPost);
    }

    @Test
    void testStatisticsWithThousandPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.usersNames()).thenReturn(Arrays.asList("User1", "User2"));
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatisticsCounter.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(500.0, forumStatisticsCounter.averageNumberOfPosts);
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfComments);
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfCommentsPerPost);
    }

    @Test
    void testStatisticsWithZeroComments() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(Arrays.asList("User1", "User2"));
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatisticsCounter.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfPosts);
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfComments);
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfCommentsPerPost);
    }

    @Test
    void testStatisticsWhenMorePostsThanComments() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(500);
        when(statisticsMock.usersNames()).thenReturn(Arrays.asList("User1", "User2"));
        when(statisticsMock.commentsCount()).thenReturn(100);
        //When
        forumStatisticsCounter.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(250.0, forumStatisticsCounter.averageNumberOfPosts);
        Assertions.assertEquals(50.0, forumStatisticsCounter.averageNumberOfComments);
        Assertions.assertEquals(0.2, forumStatisticsCounter.averageNumberOfCommentsPerPost);
    }
    @Test
    void testStatisticsWhenMoreCommentsThanPosts() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.usersNames()).thenReturn(Arrays.asList("User1", "User2"));
        when(statisticsMock.commentsCount()).thenReturn(100);
        //When
        forumStatisticsCounter.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(5.0, forumStatisticsCounter.averageNumberOfPosts);
        Assertions.assertEquals(50.0, forumStatisticsCounter.averageNumberOfComments);
        Assertions.assertEquals(10.0, forumStatisticsCounter.averageNumberOfCommentsPerPost);
    }
    @Test
    void testStatisticsWithZeroUsers() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        forumStatisticsCounter.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfPosts);
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfComments);
        Assertions.assertEquals(0.0, forumStatisticsCounter.averageNumberOfCommentsPerPost);
    }
    @Test
    void testStatisticsWithHundredUsers() {
        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.usersNames()).thenReturn(Collections.nCopies(100, "User1"));
        when(statisticsMock.commentsCount()).thenReturn(100);
        //When
        forumStatisticsCounter.calculateAdvStatistics(statisticsMock);
        //Then
        Assertions.assertEquals(10.0, forumStatisticsCounter.averageNumberOfPosts);
        Assertions.assertEquals(1.0, forumStatisticsCounter.averageNumberOfComments);
        Assertions.assertEquals(0.1, forumStatisticsCounter.averageNumberOfCommentsPerPost);
    }
}


