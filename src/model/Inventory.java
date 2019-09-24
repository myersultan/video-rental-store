package model;

import java.util.LinkedList;
import java.util.List;

public class Inventory implements InventoryDAO {

    private static String[] itemNames = {"Matrix 11", "Spider Man", "Spider Man 2", "Out Of Africa"};

    private List<Film> items;

    public Inventory() {
        items = new LinkedList<>();
        for (String itemName : itemNames) {
            items.add(new Film(itemName, true, FilmType.NEW));
        }
    }

    @Override
    public void addItem(Film item) {
        if (!items.contains(item))
            items.add(item);
    }

    @Override
    public void removeItem(Film item) {
        if (items.contains(item))
            items.remove(item);
    }

    @Override
    public void changeItemType(String title, FilmType type) {
        for (Film item : items) {
            if (item.getName().equals(title) && !item.getType().equals(type)) {
                item.setType(type);
            }
        }
    }

    @Override
    public List<Film> getAllItems() {
        return items;
    }

    @Override
    public List<Film> getAllAvailableItems() {
        List<Film> availableItems = new LinkedList<>();
        for (Film item : items) {
            if (item.isAvailable())
                availableItems.add(item);
        }

        return availableItems;
    }
}