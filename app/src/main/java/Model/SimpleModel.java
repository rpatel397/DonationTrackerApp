package Model;

import com.example.rahul.donationtrackerapp.Controllers.Location;

import java.util.ArrayList;
import java.util.List;

public class SimpleModel {

    public static final SimpleModel INSTANCE = new SimpleModel();

    private List<Location> items;

    private SimpleModel() {
        items = new ArrayList<>();
    }

    public void addItem(Location item) {
        items.add(item);
    }

    public List<Location> getItems() {
        return items;
    }

    public Location findItemById(int id) {
        for (Location location : items) {
            if (location.getKey() == id) return location;
        }
        return null;
    }
}
