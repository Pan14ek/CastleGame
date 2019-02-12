package com.javadev.funtasking.makieiev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void activateGame() {
        Level level = new Level();
        level.setLevelKing();
        boolean startGame = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi,hero! Write your name:");
        String name = scanner.next();
        Player player = new Player(name);
        player.setTotalScore(0);

        getSpecialMode(player, scanner);

        do {
            try {
                menuInformation();
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println(level.getTitle());
                        System.out.println(level.getHistory());
                        printQuestion(level,scanner,player);
                        break;
                    case 2:
                        startGame = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.print(e.getMessage());
            }
        } while (startGame && player.getHealth() > 0);
    }

    public void getSpecialMode(Player player, Scanner scanner) {
        menuMode();
        switch (scanner.nextInt()) {
            case 1:
                player.setEasyModeForHealth();
                break;
            case 2:
                player.setMiddleModeForHealth();
                break;
            case 3:
                player.setHardModeForHealth();
                break;
        }
    }

    public void printQuestion(Level level, Scanner scanner, Player player) {
        for (int i = 0; i < level.getQuests().size(); i++) {
            System.out.println(level.getQuests().get(i).getDescription());
            String playerAnswer = scanner.next();
            if (level.getQuests().get(i).getAnswer().equalsIgnoreCase(playerAnswer)) {
                System.out.println("Правильно!");
                player.setTotalScore(player.getTotalScore() + level.getQuests().get(i).getScore());
                level.getQuests().get(i).setChecked(true);
            } else {
                System.out.println("Где то ты ошибся,пошли дальше!" +
                        "\n Проиграл так проиграл,смиришь,в тюрьму тебя не посадят!");
                player.setHealth(player.getHealth() - 1);
            }
        }
        if (player.getTotalScore() >= level.getEntryScoreToNextLevel()) {
            level.setLevelWitch();
            System.out.println("Чтобы продолжить выберите Start game");
            System.out.println("На данный момент, у вас баллов :" + player.getTotalScore());
        }
    }

    public void menuInformation() {
        System.out.println("Choose point:");
        System.out.println("1.Start game");
        System.out.println("2.Exit");
    }

    public void menuMode() {
        System.out.println("Choose your mode:");
        System.out.println("1.Easy mode");
        System.out.println("2.Middle mode");
        System.out.println("3.Hard mode");
    }

}
