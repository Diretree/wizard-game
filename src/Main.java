import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Item chain = new Item("цепь",
                "Эта цепь лежит на земле в саду",
                true);
        Item well = new Item("колодец",
                "Колодец в саду",
                false);
        Item wizard = new Item("волшебник",
                "Волшебник крепко спит на диване в гостиной...",
                false);
        Item bucket = new Item("ведро",
                "В это ведро можно что-нибудь налить. Например, литров пять виски...",
                true);
        Item bottleOfWhisky = new Item("бутылка виски",
                "Уже вскрытая. И, судя по оставшемуся количеству виски внутри, кто-то хорошенько напился...",
                true);
        Item weldingTorch = new Item("газовая горелка",
                "ОСТОРОЖНО! Неплохо нагревает предметы. Можно что-нибудь приварить, а можно и дом спалить...",
                true);

        ArrayList<Item> playerItems = new ArrayList<>();

        Inventory playerInventory = new Inventory(playerItems);

        HashMap<String, Location> livingRoomPaths = new HashMap<>();
        HashMap<String, Location> gardenPaths = new HashMap<>();
        HashMap<String, Location> atticPaths = new HashMap<>();

        Location garden = new Location("Сад",
                "Вы в саду. Колодец в наличии!",
                gardenPaths);
        Location livingRoom = new Location("Гостиная",
                "Вы находитесь в гостиной. И откуда на диване взялся волшебник?!",
                livingRoomPaths);
        Location attic = new Location("Чердак",
                "Вы попали на чердак. Вполне себе эталонный грязный и пыльный чердак.",
                atticPaths);

        garden.getInventory().addInitialItem(chain);
        garden.getInventory().addInitialItem(well);
        livingRoom.getInventory().addInitialItem(wizard);
        livingRoom.getInventory().addInitialItem(bottleOfWhisky);
        livingRoom.getInventory().addInitialItem(bucket);
        attic.getInventory().addInitialItem(weldingTorch);

        garden.addPath("запад", livingRoom);
        livingRoom.addPath("восток", garden);
        livingRoom.addPath("наверх", attic);
        attic.addPath("вниз", livingRoom);

        Player player = new Player(playerInventory, livingRoom);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int moves = 0; moves < player.getMovesCount(); moves++) {
            String userInput = reader.readLine();
            String[] userInputSplit = userInput.split(" ");

            if (userInput.equals("осмотреться")) {
                player.lookAround();
                continue;
            }
            else if(userInput.equals("инвентарь")) {
                System.out.println(player.getInventory());
                continue;
            }
            else if(userInputSplit[0].equals("идти")) {
                Location newLoc = player.getCurrentLocation().getPath().get(userInputSplit[1]);
                player.setCurrentLocation(newLoc);
            }
            else if(userInputSplit[0].equals("взять")) {
                Item itemToAddIntoInventory = player.getCurrentLocation().getInventory().find(userInput.substring(userInputSplit[0].length()+1));
                playerInventory.putFromPlayer(itemToAddIntoInventory);
                player.getCurrentLocation().getInventory().removeItemFromInventory(itemToAddIntoInventory);
            }
            else if(userInput.equals("выйти из игры")) {
                System.exit(0);
            }
            else if(userInput.equals("помощь")) {
                System.out.println("Список доступных команд:" +
                                    "\nосмотреться - вы можете оглядеться вокруг, понять своё местонахождение и узнать детали окружающей обстановки;" +
                                    "\nинвентарь - посмотреть содержимое своего инвентаря;" +
                                    "\nидти восток - попробовать пойти на восток от текущего местоположения;" +
                                    "\nидти запад - попробовать пойти на запад от текущего местоположения;" +
                                    "\nидти вверх - попробовать забраться повыше;" +
                                    "\nидти вниз - спуститься;" +
                                    "\nвзять <название предмета> - подобрать предмет и положить в свой инвентарь." +
                                    "\n====================================================");
            }
            else {
                System.out.println("Вы ввели: " + userInput + "\nНе могу выполнить это действие." +
                                    "\nВведите 'помощь' для вывода списка доступных команд." +
                                    "\n====================================================");
            }
            continue;
        }

    }
}
