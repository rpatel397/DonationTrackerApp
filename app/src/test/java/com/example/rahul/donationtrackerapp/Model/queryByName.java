package com.example.rahul.donationtrackerapp.Model;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class queryByName {

    private Model actualItems = Model.INSTANCE;
    List<Item> idealList;
    String[] locations = {"AFD Station 4","Boys & Girls Club W.W. Woolfolk",
            "Pathway Upper Room Christian Ministries", "Pavilion of Hope", "D&D Convenience Store", "Keep North Fulton Beautiful"};
    @Before
    public void setUp() throws Exception {

        actualItems.add(new Item(2.00,new Timestamp(System.currentTimeMillis()),"Xbox", "1 TB XBOX",
                "Bit used", donationType.ELECTRONICS,locations[0]));
        actualItems.add(new Item(2.00,new Timestamp(System.currentTimeMillis()),"Car", "Black Car",
                "Bit used", donationType.OTHER,locations[1]));
        actualItems.add(new Item(2.00,new Timestamp(System.currentTimeMillis()),"Pants", "Blue Pants",
                "Bit used", donationType.CLOTHING,locations[2]));
        actualItems.add(new Item(2.00,new Timestamp(System.currentTimeMillis()),"Dryer", "1 TB XBOX",
                "Bit used", donationType.OTHER,locations[3]));
        actualItems.add(new Item(2.00,new Timestamp(System.currentTimeMillis()),"", "Soft white blankets",
                "Bit used", donationType.HOUSEHOLD,locations[4]));
        idealList = actualItems.getDonations();

    }
    @Test
    public void validLocation(){
        assertEquals(1,actualItems.queryItemsBasedOnName("AFD Station 4","Xbox"));
        Item[] expectedList = new Item[1];
        expectedList[0] = idealList.get(0);
        Item[] queriedList = new Item[1];
        actualItems.getDonations().toArray(queriedList);
        assertArrayEquals(expectedList,queriedList);
    }

    @Test
    public void validName(){
        assertEquals(1,actualItems.queryItemsBasedOnName("any","Dryer"));
        Item[] expectedList = new Item[1];
        expectedList[0] = idealList.get(3);
        Item[] queriedList = new Item[1];
        actualItems.getDonations().toArray(queriedList);
        assertArrayEquals(expectedList,queriedList);
    }
    @Test
    public void invalidName(){
        assertEquals(1,actualItems.queryItemsBasedOnName("D&D Convenience Store",""));
        Item[] expectedList = new Item[1];
        expectedList[0] = idealList.get(4);
        Item[] queriedList = new Item[1];
        actualItems.getDonations().toArray(queriedList);
        assertArrayEquals(expectedList,queriedList);
    }


    @After
    public void reset(){
        actualItems.setFullDonations();
        actualItems.clearDonations();
    }
}
