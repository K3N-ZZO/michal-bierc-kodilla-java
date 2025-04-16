package com.kodilla.patterns2.observer.homework;

public class HomeworkMentor implements Observer {
    private final String username;
    private int updateCount;

    public HomeworkMentor(String username) {
        this.username = username;
    }

    @Override
    public void update(HomeworkSent homeworkSent) {
        System.out.println(username + " : got new homeworks to check " + homeworkSent.getName() + "\n" +
                " total: " + homeworkSent.getHomeworks().size() + " homeworks");
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public String getUsername() {
        return username;
    }


}
