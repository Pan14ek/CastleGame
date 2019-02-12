package com.javadev.funtasking.makieiev;

public class Player {
    private static final int THREEHEALTH = 3;
    private static final int TWOHEALTH = 2;
    private static final int ONEHEALTH = 1;
    private String nickname;
    private int totalScore;
    private int health;

    public Player(){

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

    public void setEasyModeForHealth() {
        this.health = THREEHEALTH;
    }

    public void setMiddleModeForHealth(){
        this.health = TWOHEALTH;
    }

    public void setHardModeForHealth(){
        this.health = ONEHEALTH;
    }
}
