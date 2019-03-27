import java.util.HashMap;

public class Location {
    private String name;
    private String description;
    private Inventory inventory;
    private HashMap<String, Location> path;

    public Location(String name, String description, Inventory inventory, HashMap<String, Location> paths) {
            setName(name);
            setDescription(description);
            setInventory(inventory);
            setPath(paths);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description + "\nВ локации находятся следующие предметы: " + this.getInventory().toString();
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

    public HashMap<String, Location> getPath() {
        return path;
    }

    public void setPath(HashMap<String, Location> path) {
        this.path = path;
    }

    public void addPath(String way, Location location) {
        path.put(way, location);
    }
}
