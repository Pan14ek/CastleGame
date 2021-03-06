package com.javadev.funtasking.makieiev;

import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int THREEHEALTH = 3;
    private static final int TWOHEALTH = 2;
    private static final int ONEHEALTH = 1;
    private List<Level> levelsList;
    private Player player;

    public Game() {

        this.player = new Player();
    }

    public Game(Player player) {
        this.player = player;
    }

    public Game(List<Level> levelsList, Player player) {
        this.levelsList = levelsList;
        this.player = player;
    }

    Player getPlayer() {
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
        DBController dbController = new DBController();
        this.levelsList = dbController.getLevelList();
    }

    public void printQuests(Scanner scanner) {
        for (Level level : this.levelsList) {
            System.out.println(level.getTitle());
            System.out.println(level.getHistory());
            printQuestInformation(level, scanner);
            checkPlayerScoreWithEntryToNextLevel(level);
        }
    }

    private void checkPlayerScoreWithEntryToNextLevel(Level level) {
        if (this.player.getTotalScore() >= level.getEntryScoreToNextLevel()) {
            System.out.print("Поздравляем," + this.player.getNickname() + " прошли на следующий уровень!");
            System.out.println("На данный момент, " + this.player.getNickname() + " , у вас "
                    + player.getTotalScore() + " баллов\n");
        }
        isLostGame(level);
    }

    private void printQuestInformation(Level level, Scanner scanner) {
        for (int j = 0; j < level.getQuests().size(); j++) {
            System.out.println(level.getQuests().get(j).getDescription());
            String playerAnswer = scanner.next();
            checkAnswer(level.getQuests().get(j), playerAnswer);
        }
    }

    private void checkAnswer(Quest quest, String answer) {
        if (quest.getAnswer().equalsIgnoreCase(answer)) {
            System.out.println("Правильно!");
            this.player.setTotalScore(player.getTotalScore()
                    + quest.getScore());
        } else {
            System.out.println("Где то ты ошибся, пошли дальше!" +
                    "\n Проиграл так проиграл, смиришь, в тюрьму тебя не посадят!");
            this.player.setHealth(this.player.getHealth() - 1);
        }
        isLostGame();
    }

    private void isLostGame() {
        if (this.player.getHealth() <= 0) {
            getInfoAboutLostGame();
            System.exit(0);
        }
    }

    private void isLostGame(Level level) {
        if (this.player.getTotalScore() < level.getEntryScoreToNextLevel()) {
            getInfoAboutLostGame();
            System.exit(0);
        }
    }

    private void getInfoAboutLostGame() {
        DBController dbController = new DBController();
        System.out.println("Вы проиграли(You lost)");
        System.out.println("В тюрьму " + this.player.getNickname() + " ! Подумаешь , поднимешся");
        dbController.addNewScorePlayer(this.player.getNickname(), this.player.getTotalScore());
    }

    private void getSpecialMode(Scanner scanner) {
        boolean flag = true;
        do {
            menuMode();
            switch (scanner.nextInt()) {
                case 1:
                    this.player.setHealth(THREEHEALTH);
                    flag = false;
                    break;
                case 2:
                    this.player.setHealth(TWOHEALTH);
                    flag = false;
                    break;
                case 3:
                    this.player.setHealth(ONEHEALTH);
                    flag = false;
                    break;
                default:
                    System.out.println("Выбери корректный пункт меню");
                    break;
            }
        } while (flag);

    }

    public void setPlayerProfile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет,герой!Введи свое имя:");
        String name = scanner.next();
        this.player.setNickname(name);
        getSpecialMode(scanner);
        this.setLevels();
    }

    private void menuMode() {
        System.out.println("Выбери уровень сложности:");
        System.out.println("1.Легкий;");
        System.out.println("2.Средний;");
        System.out.println("3.Сложный.");
    }

    public void getTopPlayer() {
        DBController dbController = new DBController();
        dbController.getTopPlayer();
    }
}
