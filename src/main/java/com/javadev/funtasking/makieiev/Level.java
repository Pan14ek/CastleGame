package com.javadev.funtasking.makieiev;

import java.util.List;

public class Level {
    private List<Quest> quests;
    private int entryScoreToNextLevel;
    private String title;
    private String history;

    public Level() {

    }

    public Level(List<Quest> quests, int entryScoreToNextLevel, String title, String history) {
        this.quests = quests;
        this.entryScoreToNextLevel = entryScoreToNextLevel;
        this.title = title;
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public int getEntryScoreToNextLevel() {
        return entryScoreToNextLevel;
    }

    public void setEntryScoreToNextLevel(int entryScoreToNextLevel) {
        this.entryScoreToNextLevel = entryScoreToNextLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}