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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
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