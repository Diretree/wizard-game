import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;

    public Inventory(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item find(String itemName) {
        for (Item searchedItem : items) {
            if (searchedItem.getName().equals(itemName)) {
                return searchedItem;
            }
        }
        return null;
    }

    public void put(Item item) {
        if (item.isMovable()) {
            items.add(item);
            System.out.println("Вы положили " + item.getName() + " в инвентарь."); }
        else {
            System.out.println(item.getName() + " нельзя положить в инвентарь!");
        }
    }

    @Override
    public String toString() {
        return getItems().toString();
    }
}