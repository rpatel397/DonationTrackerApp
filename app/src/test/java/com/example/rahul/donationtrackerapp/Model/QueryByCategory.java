package com.example.rahul.donationtrackerapp.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


//Made by Rahul
public class QueryByCategory {
    private Model actualItems = Model.INSTANCE;
    List<Item> idealList;
    String[] locations = {"AFD Station 4","Boys & Girls Club W.W. Woolfolk",
            "Pathway Upper Room Christian Ministries", "Pavilion of Hope",
            "D&D Convenience Store", "Keep North Fulton Beautiful"};
    @Before
    public void setUp() throws Exception {

        actualItems.add(new Item(2.00, new Timestamp(System.currentTimeMillis()), "Xbox", "1 TB XBOX",
                "Bit used", donationType.ELECTRONICS,locations[0]));
        actualItems.add(new Item(2.00, new Timestamp(System.currentTimeMillis()), "PS4", "2 TB PS4",
                "Bit used", donationType.ELECTRONICS,locations[0]));
        actualItems.add(new Item(2.00, new Timestamp(System.currentTimeMillis()), "TShirt", "XL denime",
                "Bit used", donationType.CLOTHING,locations[1]));
        actualItems.add(new Item(2.00, new Timestamp(System.currentTimeMillis()), "Hoodie", "L plastic",
                "Bit used", donationType.CLOTHING,locations[1]));
        actualItems.add(new Item(2.00, new Timestamp(System.currentTimeMillis()), "Candles", "Scented",
                "Bit used", donationType.HOUSEHOLD,locations[1]));
        actualItems.add(new Item(2.00, new Timestamp(System.currentTimeMillis()), "Pan", "Non-Stick",
                "Bit used", donationType.KITCHEN,locations[0]));
        actualItems.add(new Item(2.00, new Timestamp(System.currentTimeMillis()), "Car", "old",
                "Bit used", donationType.OTHER,locations[0]));
        actualItems.add(new Item(2.00, new Timestamp(System.currentTimeMillis()), "pillow", "soft",
                "Bit used", donationType.OTHER,locations[0]));
        idealList = actualItems.getDonations();

    }

    @Test
    public void queryItemsBasedOnValidCategory() {
        assertEquals(2 ,actualItems.queryItemsBasedOnCategory("Any", "CLOTHING"));
        Item[] expectedList = new Item[2];
        expectedList[0] = idealList.get(2);
        expectedList[1] = idealList.get(3);
        Item[] queriedList = new Item[2];
        actualItems.getDonations().toArray(queriedList);
        assertArrayEquals(expectedList,queriedList);

    }

    @Test
    public void queryItemsBasedOnINValidCategory() {
        assertEquals(0 ,actualItems.queryItemsBasedOnCategory("Any", "People"));
    }

    @Test
    public void queryItemsBasedOnValidCategoryOnParticularLocation() {
        assertEquals(2 ,actualItems.queryItemsBasedOnCategory(locations[0], "ELECTRONICS"));
        Item[] expectedList = new Item[2];
        expectedList[0] = idealList.get(0);
        expectedList[1] = idealList.get(1);
        Item[] queriedList = new Item[2];
        actualItems.getDonations().toArray(queriedList);
        assertArrayEquals(expectedList,queriedList);
    }

    @Test
    public void queryItemsBasedOnValidCategoryButInvalidLocation() {
        assertEquals(0 ,actualItems.queryItemsBasedOnCategory("abra", "Electronics"));
    }

    @Test
    public void queryItemsBasedOnValidCategoryAndvalidLocationButNoItemsFound() {
        assertEquals(0 ,actualItems.queryItemsBasedOnCategory(locations[4], "Electronics"));
    }

    @Test
    public void getEmptyListWhenNullIsPassed() {
        assertEquals(0,actualItems.queryItemsBasedOnCategory(null, "Electronics"));

    }


    @After
    public void reset() {
        actualItems.setFullDonations();
        actualItems.clearDonations();
    }
}