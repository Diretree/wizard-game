import java.util.ArrayList;

public class Inventory {
    public static Item NOT_FOUND = new Item("Такого предмета тут нет! Поищи в другом месте.", "Описание пустого предмета", false);
    private ArrayList<Item> items;

    public Inventory(ArrayList<Item> items) {
        this.items = items;
    }

    public Inventory() {
        this.items = new ArrayList<>();
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
        return NOT_FOUND;
    }

    public void putFromPlayer(Item item) {
        if (item.isMovable()) {
            items.add(item);
            System.out.println("Вы положили " + item.getName() + " в инвентарь."); }
        else if (item.equals(NOT_FOUND)) {
            System.out.println(item.getName());
        }
        else {
            System.out.println(item.getName() + " нельзя положить в инвентарь!");
        }
    }

    public void addInitialItem(Item item) {
            items.add(item);
    }

    public void removeItemFromInventory(Item item) {
        items.remove(item);
    }

    @Override
    public String toString() {
        return getItems().toString();
    }
}