public class Player {
    private Inventory inventory;
    private Location currentLocation;
    private int movesCount = 1;


    public Player(Inventory inventory, Location currentLocation) {
        setInventory(inventory);
        setCurrentLocation(currentLocation);
        movesCount++;
    }

    public Player() {

    }

    public String getInventory() {
        if (inventory.getItems().isEmpty()) {
            return "Инвентарь пуст";
        }
        return inventory.getItems().toString();
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location newLocation) {
        if (newLocation == null) {
            System.out.println("В этом направлении нет пути. Попробуйте в другую сторону!");
        }
        else {
            this.currentLocation = newLocation;
            System.out.println("Вы находитесь в локации '" + currentLocation.getName() + "'");
        }
    }

    @Override
    public String toString() {
        return null;
    }

    public int getMovesCount() {
        movesCount++;
        return movesCount;
    }

    public void setMovesCount(int movesCount) {
        this.movesCount = movesCount;
    }

    public void lookAround() {
        System.out.println(currentLocation.getDescription());
    }

    public void take() {

    }

}