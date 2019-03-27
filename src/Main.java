import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Item chain = new Item("Цепь", "Эта цепь лежит на земле в саду", true);
        Item well = new Item("Колодец", "Колодец в саду", false);
        Item wizard = new Item("Волшебник", "Волшебник крепко спит на диване в гостиной...", false);
        Item bucket = new Item("Ведро", "В это ведро можно что-нибудь налить. Например, литров пять виски...", true);
        Item bottleOfWhisky = new Item("Бутылка виски", "Уже вскрытая. И, судя по оставшемуся количеству виски внутри, кто-то хорошенько напился...", true);
        Item weldingTorch = new Item("Газовая горелка", "ОСТОРОЖНО! Неплохо нагревает предметы. Можно что-нибудь приварить, а можно и дом спалить...", true);

        ArrayList<Item> gardenItems = new ArrayList<>();
        gardenItems.add(chain);
        gardenItems.add(well);

        ArrayList<Item> livingRoomItems = new ArrayList<>();
        livingRoomItems.add(wizard);
        livingRoomItems.add(bucket);
        livingRoomItems.add(bottleOfWhisky);

        ArrayList<Item> atticItems = new ArrayList<>();
        atticItems.add(weldingTorch);

        Inventory playerInventory = new Inventory();
        Inventory gardenInventory = new Inventory(gardenItems);
        Inventory livingRoomInventory = new Inventory(livingRoomItems);
        Inventory atticInventory = new Inventory(atticItems);

        HashMap<String, Location> livingRoomPath = new HashMap<>();

        Location garden = new Location("Сад", "Обычный сад. Колодец в наличии!", gardenInventory);
        Location livingRoom = new Location("Гостиная", "Гостиная. И откуда на диване взялся волшебник?!", livingRoomInventory);
        Location attic = new Location("Чердак", "Вполне себе эталонный грязный и пыльный чердак.", atticInventory);

        Player player = new Player(playerInventory, livingRoom);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int moves = 0; moves < player.getMovesCount(); moves++) {
            String userInput = reader.readLine();

            if (userInput.equals("осмотреться")) {
                player.lookAround();
                continue;
            }
            else if(userInput.equals("инвентарь")) {
                System.out.println(player.getInventory());
                continue;
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
