package com.javadev.funtasking.makieiev;

public class Quest {
    private String answer;
    private int score;
    private String description;

    public Quest() {

    }

    public Quest(String description, String answer, int score) {
        this.description = description;
        this.answer = answer;
        this.score = score;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
