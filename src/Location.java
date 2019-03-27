import java.util.HashMap;

public class Location {
    private String name;
    private String description;
    private Inventory inventory;
    private HashMap<String, Location> paths;

    public Location(String name, String description, Inventory inventory) {
            setName(name);
            setDescription(description);
            setInventory(inventory);
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public HashMap<String, Location> getPaths() {
        return paths;
    }

    public void setPaths(HashMap<String, Location> paths) {
        this.paths = paths;
    }

}
