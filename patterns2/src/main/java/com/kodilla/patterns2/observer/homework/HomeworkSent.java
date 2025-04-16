package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkSent implements Observable {
    private final List<Observer> observers;
    private final List<String> homeworks;
    private final String name;

    public HomeworkSent(String name){
        observers = new ArrayList<Observer>();
        homeworks = new ArrayList<>();
        this.name = name;
    }

    public void addHomework(String homework){
        homeworks.add(homework);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }

    }

    public List<String> getHomeworks() {
        return homeworks;
    }

    public String getName() {
        return name;
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
