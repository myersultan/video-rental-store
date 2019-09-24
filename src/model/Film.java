package model;

public class Film {

    private String name;
    private FilmType type;
    private boolean available;

    public Film(String name, boolean available, FilmType type) {
        this.name = name;
        this.available = available;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FilmType getType() {
        return type;
    }

    public void setType(FilmType type) {
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
