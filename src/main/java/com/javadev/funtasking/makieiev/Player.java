package com.javadev.funtasking.makieiev;

public class Player {
    private static final int RANDOM_NUMBER = 5;
    private String nickname;
    private int totalScore;
    private int health;

    public Player() {
        this.health = RANDOM_NUMBER;
    }

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
