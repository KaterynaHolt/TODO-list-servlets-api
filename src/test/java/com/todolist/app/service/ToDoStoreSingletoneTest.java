package com.todolist.app.service;

import com.todolist.app.model.Item;
import com.todolist.app.model.Status;
import com.todolist.app.service.ToDoStoreSingletone;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.mockito.Spy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ToDoStoreSingletoneTest {
    @Spy
    private ToDoStoreSingletone singletone = ToDoStoreSingletone.Instance();
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test adding one item - addItem
     */
    @Test
    public void test_adding_one_item(){
        //WHEN
        singletone.addItem("The first item");
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == 1);
        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.INCOMPLETED);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The first item");
    }

    /**
     * Test adding several items - addItem
     */
    @Test
    public void test_adding_several_items(){
        //WHEN
        singletone.addItem("The first item");
        singletone.addItem("The second item");
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == 2);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The first item");
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The second item");
    }

    /**
     * Test adding the same items - addItem
     */
    @Test
    public void test_adding_the_same_items(){
        //WHEN
        singletone.addItem("The first item");
        singletone.addItem("The first item");
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == 2);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The first item");
    }

    /**
     * Test changing status of items from incompleted to completed - changeStatus
     */
    @Test
    public void test_completing_status(){
        //GIVEN
        singletone.addItem("The first item");
        singletone.addItem("The second item");
        Item item1 = new Item("The first Item", Status.COMPLETED);
        Item item2 = new Item("The second Item", Status.INCOMPLETED);
        //WHEN
        singletone.changeStatus(1, Status.COMPLETED);
        //THEN
        assertThat(singletone.getItems().values().toArray()[0].equals(item1));
        assertThat(singletone.getItems().values().toArray()[1].equals(item2));
    }

    /**
     * Test changing status of items from completed to incompleted - changeStatus
     */
    @Test
    public void test_incompleting_status(){
        //GIVEN
        singletone.addItem("The first item");
        singletone.addItem("The second item");
        singletone.addItem("The third item");
        Item item1 = new Item("The first Item", Status.INCOMPLETED);
        Item item2 = new Item("The second Item", Status.COMPLETED);
        Item item3 = new Item("The third Item", Status.INCOMPLETED);
        //WHEN
        singletone.changeStatus(1, Status.COMPLETED);
        singletone.changeStatus(2, Status.COMPLETED);
        singletone.changeStatus(1, Status.INCOMPLETED);
        //THEN
        assertThat(singletone.getItems().values().toArray()[0].equals(item1));
        assertThat(singletone.getItems().values().toArray()[1].equals(item2));
        assertThat(singletone.getItems().values().toArray()[2].equals(item3));
    }

    /**
     * Test removing one item - removeItem
     */
    @Test
    public void test_removing_item(){
        //GIVEN
        singletone.addItem("Item 1");
        singletone.addItem("Item 2");
        //WHEN
        singletone.removeItem(1);
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == 1);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("Item 2");
    }

    /**
     * Test removing several items - removeItem
     */
    @Test
    public void test_removing_several_items(){
        //GIVEN
        singletone.addItem("Item 1");
        singletone.addItem("Item 2");
        singletone.addItem("Item 3");
        //WHEN
        singletone.removeItem(3);
        singletone.removeItem(1);
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == 1);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("Item 2");
    }

    /**
     * Test select data from store and print method - printAll
     */
    @Test
    public void test_printing_items(){
        //GIVEN
        ByteArrayOutputStream st = new ByteArrayOutputStream();
        PrintStream print = System.out;
        System.setOut(new PrintStream(st));
        singletone.addItem("Item 1");
        singletone.addItem("Item 2");
        //WHEN
        singletone.printAll();
        //THEN
        Assertions.assertEquals("=========TO DO LIST=============\n" +
                "|#  |    Title   |   Status   |\n" +
                "|1. |     Item 1 |INCOMPLETED |\n" +
                "|2. |     Item 2 |INCOMPLETED |\n" +
                "================================\n", st.toString());
        System.setOut(print);
    }
}
