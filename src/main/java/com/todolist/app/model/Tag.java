package com.todolist.app.model;


public enum Tag {
    DAILYROUTINE,
    HOME,
    WORK,
    READING;

    @Override
    public String toString() {
        String str = name().toLowerCase().substring(0, 1).toUpperCase() + name().toLowerCase().substring(1);
        return str;
    }
}
