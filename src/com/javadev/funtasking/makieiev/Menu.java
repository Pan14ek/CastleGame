package com.javadev.funtasking.makieiev;

import java.util.Scanner;

public class Menu {
    public void activateGame() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi,hero! Write your name:");
        String name = scanner.next();
        Player player = new Player(name);
        Levels levels = new Levels(player);
        levels.setLevels();
        menuController(levels, scanner);
    }

    public void menuInformation() {
        System.out.println("Choose point:");
        System.out.println("1.Start game");
        System.out.println("2.Exit");
    }

    private void menuController(Levels levels, Scanner scanner) {
        boolean startGame = true;
        levels.getSpecialMode(scanner);
        do {
            menuInformation();
            switch (scanner.nextInt()) {
                case 1:
                    levels.printQuests(scanner);
                    break;
                case 2:
                    startGame = false;
                    break;
            }
        } while (startGame && levels.getPlayer().getHealth() > 0);
    }
}
