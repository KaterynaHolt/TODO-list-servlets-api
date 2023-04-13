package com.todolist.app.service;


import com.todolist.app.model.Item;
import com.todolist.app.model.Priority;
import com.todolist.app.model.Status;
import com.todolist.app.model.Tag;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.mockito.Spy;
import java.util.ArrayList;
import java.util.List;


public class ToDoStoreSingletoneTest {
    @Spy
    private ToDoStoreSingleton singletone = ToDoStoreSingleton.getInstance();
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test adding one item - addItem
     */
    @Test
    public void test_adding_one_item(){
        //GIVEN
        List<Tag> tags = new ArrayList<>();
        tags.add(Tag.WORK);
        tags.add(Tag.READING);
        Item item1 = new Item("The first Item", "02.04.2023", Status.COMPLETED, Priority.NORMAL, tags);
        int size = singletone.getItems().size();
        //WHEN
        singletone.addItem(item1);
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == size + 1);
        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.COMPLETED);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The first Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("02.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.NORMAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags);
    }

    /**
     * Test adding several items - addItem
     */
    @Test
    public void test_adding_several_items(){
        //GIVEN
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        tags1.add(Tag.READING);
        Item item1 = new Item("The first Item", "02.04.2023", Status.PENDING, Priority.NORMAL, tags1);
        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DAILYROUTINE);
        tags2.add(Tag.HOME);
        Item item2 = new Item("The second Item", "03.04.2023", Status.INPROGRESS, Priority.CRITICAL, tags2);
        int size = singletone.getItems().size();
        //WHEN
        singletone.addItem(item1);
        singletone.addItem(item2);
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == size + 2);
        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.PENDING);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The first Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("02.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.NORMAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags1);

        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.INPROGRESS);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The second Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("03.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.CRITICAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags2);
    }

    /**
     * Test adding the same items - addItem
     */
    @Test
    public void test_adding_the_same_items(){
        //GIVEN
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        tags1.add(Tag.READING);
        Item item1 = new Item("The first Item", "02.04.2023", Status.PENDING, Priority.NORMAL, tags1);
        int size = singletone.getItems().size();
        //WHEN
        singletone.addItem(item1);
        singletone.addItem(item1);
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == size + 2);
        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.PENDING);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The first Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("02.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.NORMAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags1);
    }

    /**
     * Test changing status of items to completed - changeStatus
     */
    @Test
    public void test_completing_status(){
        //GIVEN
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        tags1.add(Tag.READING);
        Item item1 = new Item("The first Item", "02.04.2023", Status.PENDING, Priority.NORMAL, tags1);
        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DAILYROUTINE);
        tags2.add(Tag.HOME);
        Item item2 = new Item("The second Item", "03.04.2023", Status.INPROGRESS, Priority.CRITICAL, tags2);
        String id1 = singletone.addItem(item1);
        String id2 = singletone.addItem(item2);
        int size = singletone.getItems().size();
        //WHEN
        singletone.changeStatus(id1, Status.COMPLETED);
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == size);
        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.COMPLETED);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The first Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("02.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.NORMAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags1);

        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.INPROGRESS);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The second Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("03.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.CRITICAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags2);
    }

    /**
     * Test changing status of items to incompleted - changeStatus
     */
    @Test
    public void test_incompleting_status(){
        //GIVEN
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        tags1.add(Tag.READING);
        Item item1 = new Item("The first Item", "02.04.2023", Status.COMPLETED, Priority.NORMAL, tags1);
        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DAILYROUTINE);
        tags2.add(Tag.HOME);
        Item item2 = new Item("The second Item", "03.04.2023", Status.COMPLETED, Priority.CRITICAL, tags2);
        List<Tag> tags3 = new ArrayList<>();
        tags3.add(Tag.DAILYROUTINE);
        tags3.add(Tag.HOME);
        tags3.add(Tag.WORK);
        tags3.add(Tag.READING);
        Item item3 = new Item("The third Item", "13.04.2023", Status.COMPLETED, Priority.MINOR, tags3);
        String id1 = singletone.addItem(item1);
        String id2 = singletone.addItem(item2);
        String id3 = singletone.addItem(item3);
        int size = singletone.getItems().size();
        //WHEN
        singletone.changeStatus(id3, Status.INCOMPLETED);
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == size);
        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.COMPLETED);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The first Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("02.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.NORMAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags1);

        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.COMPLETED);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The second Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("03.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.CRITICAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags2);

        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.INCOMPLETED);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The third Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("13.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.MINOR);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags3);
    }

    /**
     * Test changing information about item - changeInformation
     */
    @Test
    public void test_changing_information(){
        //GIVEN
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        tags1.add(Tag.READING);
        Item item1 = new Item("The first Item", "02.04.2023", Status.PENDING, Priority.NORMAL, tags1);
        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DAILYROUTINE);
        tags2.add(Tag.HOME);
        Item item2 = new Item("The second Item", "03.04.2023", Status.INPROGRESS, Priority.CRITICAL, tags2);
        String id1 = singletone.addItem(item1);
        String id2 = singletone.addItem(item2);
        Item item3 = new Item("The changed Item", "13.04.2023", Status.INCOMPLETED, Priority.MINOR, tags1);
        int size = singletone.getItems().size();
        //WHEN
        singletone.changeItem(id2, item3);
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == size);
        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.COMPLETED);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The first Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("02.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.NORMAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags1);

        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.INCOMPLETED);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The changed Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("13.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.MINOR);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags1);
    }

    /**
     * Test removing one item - removeItem
     */
    @Test
    public void test_removing_item(){
        //GIVEN
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        tags1.add(Tag.READING);
        Item item1 = new Item("The first Item", "02.04.2023", Status.PENDING, Priority.NORMAL, tags1);
        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DAILYROUTINE);
        tags2.add(Tag.HOME);
        Item item2 = new Item("The second Item", "03.04.2023", Status.INPROGRESS, Priority.CRITICAL, tags2);
        String id1 = singletone.addItem(item1);
        String id2 = singletone.addItem(item2);
        int size = singletone.getItems().size();
        //WHEN
        singletone.removeItem(id1);
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == size - 1);
        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.INPROGRESS);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The second Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("03.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.CRITICAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags2);
    }

    /**
     * Test removing several items - removeItem
     */
    @Test
    public void test_removing_several_items(){
        //GIVEN
        List<Tag> tags1 = new ArrayList<>();
        tags1.add(Tag.WORK);
        tags1.add(Tag.READING);
        Item item1 = new Item("The first Item", "02.04.2023", Status.PENDING, Priority.NORMAL, tags1);
        List<Tag> tags2 = new ArrayList<>();
        tags2.add(Tag.DAILYROUTINE);
        tags2.add(Tag.HOME);
        Item item2 = new Item("The second Item", "03.04.2023", Status.INPROGRESS, Priority.CRITICAL, tags2);
        List<Tag> tags3 = new ArrayList<>();
        tags3.add(Tag.DAILYROUTINE);
        tags3.add(Tag.HOME);
        tags3.add(Tag.WORK);
        tags3.add(Tag.READING);
        Item item3 = new Item("The third Item", "13.04.2023", Status.COMPLETED, Priority.MINOR, tags3);
        String id1 = singletone.addItem(item1);
        String id2 = singletone.addItem(item2);
        String id3 = singletone.addItem(item2);
        int size = singletone.getItems().size();
        //WHEN
        singletone.removeItem(id2);
        singletone.removeItem(id3);
        //THEN
        Assertions.assertTrue(singletone.getItems().size() == size - 2);
        assertThat(singletone.getItems().values()).extracting(Item::getStatus).contains(Status.PENDING);
        assertThat(singletone.getItems().values()).extracting(Item::getValue).contains("The first Item");
        assertThat(singletone.getItems().values()).extracting(Item::getDate).contains("02.04.2023");
        assertThat(singletone.getItems().values()).extracting(Item::getPriority).contains(Priority.NORMAL);
        assertThat(singletone.getItems().values()).extracting(Item::getTags).contains(tags1);
    }
}
