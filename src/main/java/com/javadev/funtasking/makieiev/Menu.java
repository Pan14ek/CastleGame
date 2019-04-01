package com.javadev.funtasking.makieiev;

import java.util.Scanner;

public class Menu {
    public void activateGame() {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        menuController(game, scanner);
    }

    private void menuInformation() {
        System.out.println("Choose point:");
        System.out.println("1.Write your profile");
        System.out.println("2.Start game");
        System.out.println("3.Max score");
        System.out.println("4.Exit");
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
                    System.out.println("Your wrote wrong number");
                    break;
            }
        } while (startGame && game.getPlayer().getHealth() > 0);
    }
}
