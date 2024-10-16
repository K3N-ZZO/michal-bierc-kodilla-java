package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.kodilla.stream.forumuser.Forum;

public class Forum {
    private final List<ForumUser> users = new ArrayList<>();

    public Forum(){
        users.add(new ForumUser(1,"name1",'M', LocalDate.of(2001,5,15), 100));
        users.add(new ForumUser(2,"name2",'M', LocalDate.of(1999,11,25), 200));
        users.add(new ForumUser(3,"name3",'K', LocalDate.of(1989,1,17), 133));
        users.add(new ForumUser(4,"name4",'K', LocalDate.of(2005,9,3), 10));
        users.add(new ForumUser(5,"name5",'M', LocalDate.of(1975,4,5), 58));

    }


    public List<ForumUser> getUsers() {
        return new ArrayList<>(users);
    }
}
