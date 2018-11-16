package com.example.rahul.donationtrackerapp.Model;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

public class FindDonationByKey {
    private Model actualItems = Model.INSTANCE;
    List<Item> idealList;
    String[] locations = {"AFD Station 4","Boys & Girls Club W.W. Woolfolk",
            "Pathway Upper Room Christian Ministries", "Pavilion of Hope",
            "D&D Convenience Store", "Keep North Fulton Beautiful"};
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
    public void validItem() {
        assertEquals(idealList.get(0), actualItems.findDonationByKey(idealList.get(0).getKey()));
    }

    @Test
    public void invalidItem() {
        Item newItem = new Item(100000.00,new Timestamp(System.currentTimeMillis()),"Something New", "Something New",
                "This is a test", donationType.OTHER,locations[3]);
        assertNull(actualItems.findDonationByKey(newItem.getKey()));
    }

}
