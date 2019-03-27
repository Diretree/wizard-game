import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Item chain = new Item("Цепь",
                "Эта цепь лежит на земле в саду",
                true);
        Item well = new Item("Колодец",
                "Колодец в саду",
                false);
        Item wizard = new Item("Волшебник",
                "Волшебник крепко спит на диване в гостиной...",
                false);
        Item bucket = new Item("Ведро",
                "В это ведро можно что-нибудь налить. Например, литров пять виски...",
                true);
        Item bottleOfWhisky = new Item("Бутылка виски",
                "Уже вскрытая. И, судя по оставшемуся количеству виски внутри, кто-то хорошенько напился...",
                true);
        Item weldingTorch = new Item("Газовая горелка",
                "ОСТОРОЖНО! Неплохо нагревает предметы. Можно что-нибудь приварить, а можно и дом спалить...",
                true);

        ArrayList<Item> gardenItems = new ArrayList<>();
        gardenItems.add(chain);
        gardenItems.add(well);

        ArrayList<Item> livingRoomItems = new ArrayList<>();
        livingRoomItems.add(wizard);
        livingRoomItems.add(bucket);
        livingRoomItems.add(bottleOfWhisky);

        ArrayList<Item> atticItems = new ArrayList<>();
        atticItems.add(weldingTorch);

        ArrayList<Item> playerItems = new ArrayList<>();

        Inventory playerInventory = new Inventory(playerItems);
        Inventory gardenInventory = new Inventory(gardenItems);
        Inventory livingRoomInventory = new Inventory(livingRoomItems);
        Inventory atticInventory = new Inventory(atticItems);

        HashMap<String, Location> livingRoomPaths = new HashMap<>();
        HashMap<String, Location> gardenPaths = new HashMap<>();
        HashMap<String, Location> atticPaths = new HashMap<>();

        Location garden = new Location("Сад",
                "Вы в саду. Колодец в наличии!", gardenInventory,
                gardenPaths);
        Location livingRoom = new Location("Гостиная",
                "Вы находитесь в гостиной. И откуда на диване взялся волшебник?!", livingRoomInventory,
                livingRoomPaths);
        Location attic = new Location("Чердак",
                "Вы попали на чердак. Вполне себе эталонный грязный и пыльный чердак.", atticInventory,
                atticPaths);

        garden.addPath("запад", livingRoom);
        livingRoom.addPath("восток", garden);
        livingRoom.addPath("наверх", attic);
        attic.addPath("вниз", livingRoom);

        Player player = new Player(playerInventory, livingRoom);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int moves = 0; moves < player.getMovesCount(); moves++) {
            String userInput = reader.readLine();
            String[] userInputSplitted = userInput.split(" ");

            if (userInput.equals("осмотреться")) {
                player.lookAround();
                continue;
            }
            else if(userInput.equals("инвентарь")) {
                System.out.println(player.getInventory());
                continue;
            }
            else if(userInputSplitted[0].equals("идти")) {
                Location newLoc = player.getCurrentLocation().getPath().get(userInputSplitted[1]);
                player.setCurrentLocation(newLoc);
            }
            else if(userInputSplitted[0].equals("взять")) {
                Item itemToAddIntoInventory = player.getCurrentLocation().getInventory().find(userInputSplitted[1]);
                playerInventory.put(itemToAddIntoInventory);
            }
            else if(userInput.equals("выйти из игры")) {
                System.exit(0);
            }
            else {
                System.out.println("Вы ввели: " + userInput + "\nНе могу выполнить это действие.");
            }
            continue;
        }

    }
}
