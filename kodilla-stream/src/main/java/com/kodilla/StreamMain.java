package com.kodilla;

import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;


import com.kodilla.stream.book.Book;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class StreamMain {
    public static void main(String[] args) {

        BookDirectory bookDirectory = new BookDirectory();
        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultListOfForumUsers = forum.getUsers().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().isBefore(LocalDate.of(2004,10,17)))
                .filter(forumUser -> forumUser.getNumberOfPosts() > 1)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        System.out.println("# elements: " + theResultListOfForumUsers.size());
        theResultListOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);
    }
}
