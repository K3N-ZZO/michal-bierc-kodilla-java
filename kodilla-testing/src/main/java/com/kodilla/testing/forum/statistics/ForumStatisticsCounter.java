package com.kodilla.testing.forum.statistics;

public class ForumStatisticsCounter {
    int numberOfUsers;
    int numberOfPosts;
    int numberOfComments;
    double averageNumberOfPosts;
    double averageNumberOfComments;
    double averageNumberOfCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        this.numberOfUsers = statistics.usersNames().size();
        this.numberOfPosts = statistics.postsCount();
        this.numberOfComments = statistics.commentsCount();

        //Obliczanie średnich
        if (numberOfUsers > 0) {
            this.averageNumberOfPosts =  numberOfPosts / (double) numberOfUsers;
            this.averageNumberOfComments = numberOfComments / (double) numberOfUsers;
        } else {
            this.averageNumberOfPosts = 0.0;
            this.averageNumberOfComments = 0.0;
        }

        if (numberOfPosts > 0) {
            this.averageNumberOfCommentsPerPost =  numberOfComments / (double) numberOfPosts;
        } else {
            this.averageNumberOfCommentsPerPost = 0.0;
        }
    }
    public void showStatistics(){
        System.out.println("Wyświetlam przygotowane statystyki: ");
        System.out.println("Liczba użytkowników: " + numberOfUsers);
        System.out.println("Liczba postów:"  + numberOfPosts);
        System.out.println("Liczba komentarzy: " + numberOfComments);
        System.out.println("Średnia liczba postów: " + averageNumberOfPosts);
        System.out.println("Średnia liczba komentarzy: " + averageNumberOfComments);
        System.out.println("Średnia liczba komentarzy na post: " + averageNumberOfCommentsPerPost);
    }
}
