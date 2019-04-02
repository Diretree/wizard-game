public class Player {
    private Inventory inventory;
    private Location currentLocation;
    private int movesCount = 1;


    public Player(Inventory inventory, Location currentLocation) {
        setInventory(inventory);
        setCurrentLocation(currentLocation);
        movesCount++;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String showInventory() {
        if (inventory.getItems().isEmpty()) {
            return "Инвентарь пуст";
        }
        return inventory.getItems().toString();
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

    public void take(String item) {
        if (getCurrentLocation().getInventory().find(item) == getInventory().NOT_FOUND) {
            System.out.println(getInventory().NOT_FOUND);
        }
        else if (!getCurrentLocation().getInventory().find(item).isMovable()) {
            System.out.println(item + " нельзя положить в инвентарь!");
        }
        else {
            Item itemToAddIntoInventory = this.getCurrentLocation().getInventory().find(item);
            inventory.putFromPlayer(itemToAddIntoInventory);
            this.getCurrentLocation().getInventory().removeItemFromInventory(itemToAddIntoInventory);
        }
    }

    public void use(String item1, String item2) {
        if (item1.equals("ведро") && item2.equals("цепь") && getInventory().find(item1) != inventory.NOT_FOUND &&
                getInventory().find(item2) != inventory.NOT_FOUND) {
            if (getInventory().find("газовая горелка") == getInventory().NOT_FOUND) {
                System.out.println("Вам нужна газовая горелка, чтобы приварить ведро к цепи.");
            } else {
                Item bucketWithChain = new Item("ведро на цепи", "Это ведро с приваренной к нему цепью. Удобно!", true);

                inventory.removeItemFromInventory(inventory.find(item1));
                inventory.removeItemFromInventory(inventory.find(item2));

                inventory.addInitialItem(bucketWithChain);

                System.out.println("Вы приварили цепь к ведру. Теперь возможности ведра практически безграничны!");
            }
        }
        else if (item1.equals(getInventory().find("ведро на цепи").getName()) && item2 == "колодец" &&
                getCurrentLocation().getName() != "Сад") {

            System.out.println("Тут нет колодца. Попробуйте поискать в другом месте!");
        }
        else if (item1.equals(getInventory().find("ведро на цепи").getName()) &&
                item2.equals(getCurrentLocation().getInventory().find("колодец").getName()) &&
                getCurrentLocation().getName() == "Сад") {
            Item bucketFullOfWater = new Item("ведро с водой", "Это ведро наполнено водой до краёв. Можно кого-нибудь окатить.", true);

            inventory.removeItemFromInventory(inventory.find(item1));
            inventory.addInitialItem(bucketFullOfWater);

            System.out.println("Вы набрали в ведро воду.");
        }
        else if (item1.equals(getInventory().find("ведро с водой").getName()) && item2 == "волшебник" &&
                getCurrentLocation().getName() != "Гостиная") {

            System.out.println("Тут нет волшебника. Попробуйте поискать в другом месте!");
        }
        else if (item1.equals(getInventory().find("ведро с водой").getName()) &&
                item2.equals(getCurrentLocation().getInventory().find("волшебник").getName()) &&
                getCurrentLocation().getName() == "Гостиная") {
            Item magicCrystal = new Item("магический кристалл", "Теперь вы обладаете невиданной силой!", true);

            inventory.removeItemFromInventory(inventory.find(item1));
            inventory.addInitialItem(magicCrystal);

            System.out.println("Волшебник проснулся, и в знак благодарности дал вам магический кристалл. Цель выполнена!");
            System.exit(0);
        }
        else {
            System.out.println("Невозможно использовать " + item1 + " и " + item2 + ".");
        }
        }
}