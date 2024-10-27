package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {
        User user = null;
        MessageSender ms = new MessageSender();
        try {
            ms.sendMessageTo(user,"Hello!");
        } catch (MessageNotSendException e) {
            System.out.println("Message is not send, "+ "but program still running" +
                    "very well!");
        }
        System.out.println("Processing other logic! ");
    }
}
