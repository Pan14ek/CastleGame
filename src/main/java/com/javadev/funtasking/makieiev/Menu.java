package com.javadev.funtasking.makieiev;

import java.util.Scanner;

public class Menu {
    public void activateGame() {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        menuController(game, scanner);
    }

    private void menuInformation() {
        System.out.println("Добро пожаловать,рыцарь!");
        System.out.println("Выбери пункт меню:");
        System.out.println("1.Ввести имя;");
        System.out.println("2.Начать игру;");
        System.out.println("3.Максимальный балл у игроков;");
        System.out.println("4.Выход.");
    }

    private void menuController(Game game, Scanner scanner) {
        boolean startGame = true;
        boolean profile = false;
        do {
            menuInformation();
            switch (scanner.nextInt()) {
                case 1:
                    game.setPlayerProfile();
                    profile = true;
                    break;
                case 2:
                    if (profile) {
                        game.printQuests(scanner);
                    } else {
                        System.out.println("Сперва заполни свой профиль");
                    }
                    break;
                case 3:
                    game.getTopPlayer();
                    startGame = false;
                    break;
                case 4:
                    startGame = false;
                    break;
                default:
                    System.out.println("Выберите корректный пункт меню");
                    break;
            }
        } while (startGame && game.getPlayer().getHealth() > 0);
    }
}
