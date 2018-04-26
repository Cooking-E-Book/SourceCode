package com.telerikacademy;

abstract class Message {

    String text;

    public String getInput() {
        return text;
    }

    public void setInput(String text) {
        this.text = text;
    }
}
