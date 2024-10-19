package com.kodilla;

import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;


public class StreamMain {
    public static void main(String[] args) {

        BookDirectory bookDirectory = new BookDirectory();
        Forum forum = new Forum();
        LocalDate startDate = LocalDate.of(2004, 10, 19);
        LocalDate endDate = LocalDate.of(2024, 10, 19);
        Map<Integer, ForumUser> theResultListOfForumUsers = forum.getUsers().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> Period.between(forumUser.getDateOfBirth(),LocalDate.now()).getYears() >= 20)
                .filter(forumUser -> forumUser.getNumberOfPosts() > 1)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        System.out.println("# elements: " + theResultListOfForumUsers.size());
        theResultListOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);
    }
}
