package com.javadev.funtasking.makieiev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Levels {
    private List<Level> levelsList;
    private Player player;

    public Levels() {
    }

    public Levels(Player player) {
        this.player = player;
    }

    public Levels(List<Level> levelsList, Player player) {
        this.levelsList = levelsList;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Level> getLevelsList() {
        return levelsList;
    }

    public void setLevelsList(List<Level> levelsList) {
        this.levelsList = levelsList;
    }

    public void setLevels() {
        this.levelsList = new ArrayList<>();
        Level firstLevel = new Level();
        Level secondLevel = new Level();

        firstLevel.setLevelKing();
        secondLevel.setLevelWitch();

        this.levelsList.add(firstLevel);
        this.levelsList.add(secondLevel);
    }

    public void printQuests(Scanner scanner) {
        for (int i = 0; i < this.levelsList.size(); i++) {
            System.out.println(this.levelsList.get(i).getTitle());
            System.out.println(this.levelsList.get(i).getHistory());
            printQuestInformation(this.levelsList.get(i), scanner);
            if (player.getTotalScore() >= this.levelsList.get(i).getEntryScoreToNextLevel()) {
                System.out.println("Поздравляем," + this.player.getNickname() + " прошли на следующий уровень!");
                System.out.println("На данный момент," + this.player.getNickname() + ", у вас"
                        + player.getTotalScore() + " баллов\n");
            } else {
                System.out.println("В тюрьму " + this.player.getNickname() + " ! Пускай еще подумает");
                break;
            }
        }
    }

    private void printQuestInformation(Level level, Scanner scanner) {
        for (int j = 0; j < level.getQuests().size(); j++) {
            System.out.println(level.getQuests().get(j).getDescription());
            String playerAnswer = scanner.next();
            if (level.getQuests().get(j).getAnswer().equalsIgnoreCase(playerAnswer)) {
                System.out.println("Правильно!");
                this.player.setTotalScore(player.getTotalScore()
                        + level.getQuests().get(j).getScore());
                level.getQuests().get(j).setChecked(true);
            } else {
                System.out.println("Где то ты ошибся, пошли дальше!" +
                        "\n Проиграл так проиграл, смиришь, в тюрьму тебя не посадят!");
                player.setHealth(player.getHealth() - 1);
            }
        }
    }

    public void getSpecialMode(Scanner scanner) {
        menuMode();
        switch (scanner.nextInt()) {
            case 1:
                this.player.setEasyModeForHealth();
                break;
            case 2:
                this.player.setMiddleModeForHealth();
                break;
            case 3:
                this.player.setHardModeForHealth();
                break;
        }
    }

    public void menuMode() {
        System.out.println("Choose your mode:");
        System.out.println("1.Easy mode");
        System.out.println("2.Middle mode");
        System.out.println("3.Hard mode");
    }
}
