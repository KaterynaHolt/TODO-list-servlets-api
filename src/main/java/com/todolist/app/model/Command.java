package com.todolist.app.model;

/**
 * These are commands, which are available for using
 */
public enum Command {
    /**
     * Command for adding an item to the todo app
     */
    ADD,
    /**
     * Command for completing a given item
     */
    COMPLETE,
    /**
     * Command for undoing a given item
     */
    INCOMPLETE,
    /**
     * Command for removing element from the todo app
     */
    REMOVE,
    /**
     * Command for printing all todo items Help
     */
    PRINT_ALL,
    /**
     * Command for saving all todo list items to the txt file
     */
    SAVE_TO_FILE,
    /**
     * Command for saving all the items to the database
     */
    SAVE_TO_DB,
    /**
     * Command for displaying list of available commands
     */
    HELP,
    /**
     * Command for exiting the application
     */
    EXIT
}
