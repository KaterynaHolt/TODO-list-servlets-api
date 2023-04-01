package com.todolist.app.model;


/**
 * These are statuses, which user can mark his tasks
 */
public enum Status {
    /**
     * This status means that the task is done
     */
    COMPLETED,
    /**
     * This status means that the task hasn't been done yet
     */
    INCOMPLETED,
    /**
     * This status means that the task is being worked
     */
    INPROGRESS,
    /**
     * This status means that the task is in a queue
     */
    PENDING
}
