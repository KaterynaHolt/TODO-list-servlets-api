package com.todolist.app.model;


public final class ToDoListAppConstants {
    /**
     * This constant represents add button on see-all-tasks page.
     */
    private static final String ADD_OPERATION = "ADD";

    private ToDoListAppConstants() {
    }

    public static String getAddOperation(){
        return ADD_OPERATION;
    }
}
