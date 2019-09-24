package model;

import java.util.List;

public interface InventoryDAO {

    void addItem(Film item);

    void removeItem(Film item);

    void changeItemType(String title, FilmType type);

    List<Film> getAllItems();

    List<Film> getAllAvailableItems();
}
