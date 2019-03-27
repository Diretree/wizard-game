public class Item {
    private String name;
    private String description;
    private boolean movable;

    public Item(String name, String description, boolean movable) {
        setName(name);
        setDescription(description);
        setMovable(movable);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }
}