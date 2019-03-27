package com.javadev.funtasking.makieiev;

import java.util.Scanner;

public class Menu {
    public void activateGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi,hero! Write your name:");
        String name = scanner.next();
        Game game = new Game(new Player(name));
        game.setLevels();
        menuController(game, scanner);
    }

    private void menuInformation() {
        System.out.println("Choose point:");
        System.out.println("1.Start game");
        System.out.println("2.TOP Player");
        System.out.println("3.Exit");
    }

    private void menuController(Game game, Scanner scanner) {
        boolean startGame = true;
        game.getSpecialMode(scanner);
        do {
            menuInformation();
            switch (scanner.nextInt()) {
                case 1:
                    game.printQuests(scanner);
                    break;
                case 2:
                    game.getTopPlayer();
                    break;
                case 3:
                    startGame = false;
                    break;
                default:
                    System.out.println("Your wrote wrong number");
                    break;
            }
        } while (startGame && game.getPlayer().getHealth() > 0);
    }
}
