package com.kodilla.testing.forum;

import java.util.*;

public class ForumUser {
    private String name;
    private String realName;
    private List<ForumPost> posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }
    public void addPost(String author, String postBody) {
        ForumPost post = new ForumPost(author, postBody);
        posts.add(post);
    }
    public void addComment(ForumPost thePost, String author, String commentBody) {
        ForumComment comment = new ForumComment(thePost, author, commentBody);
        comments.add(comment);
    }
    public int getPostQuantity(){
        return posts.size();
    }
    public int getCommentQuantity(){
        return comments.size();
    }
    public ForumPost getPost(int postNumber) {
        if (postNumber >= 0 && postNumber < posts.size()) {
            return posts.get(postNumber);
        }
        return null;
    }
    public ForumComment getComment(int CommentNumber) {
        ForumComment theComment = null;
        if (CommentNumber >= 0 && CommentNumber < comments.size()) {
            theComment = comments.get(CommentNumber);
        }
        return theComment;
    }
    public boolean removePost(ForumPost thePost) {
        boolean result = false;
        if(posts.contains(thePost)) {
            posts.remove(thePost);
            result = true;
        }
        return result;
    }
    public boolean removeComment(ForumComment theComment) {
        boolean result = false;
        if (comments.contains(theComment)) {
            comments.remove(theComment);
            result = true;
        }
        return result;
    }
    public String getName() {
        return name;
    }
    public String getRealName() {
        return realName;
    }
}
