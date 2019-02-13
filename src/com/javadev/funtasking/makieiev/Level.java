package com.javadev.funtasking.makieiev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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

    public void printRandomQuest(Scanner scanner, Player player) {
        Random random = new Random();
        int randQuest = random.nextInt(quests.size());
        Quest quest = quests.get(randQuest);
        if (!quest.isChecked()) {
            quest.getDescription();
            System.out.println("Write your answer");
            String playerAnswer = scanner.next();
            if (quest.getAnswer().equals(playerAnswer)) {
                player.setTotalScore(player.getTotalScore() + quest.getScore());
            }
        }
    }

    public Level setLevelKing() {
        this.quests = new ArrayList<>();
        this.quests.add(new Quest("Феодалы очень любили пировать  в своих замках." +
                " Как ты думаешь, из чего была сделана большая часть тарелок." +
                "Выбери букву:\n" +
                "а)Хлеб;\n" +
                "б)Дерево;\n" +
                "в)Железа.", "а", 5, false));
        this.quests.add(new Quest("Как называется самая высокая и неприступная башня замка(центральная башня):" +
                "Выбери букву:\n" +
                "а)Каркасон;\n" +
                "б)Замковый туалет на 2 этаже по левому коридору;\n" +
                "в)Донжон.",
                "в", 10, false));
        this.quests.add(new Quest("Первые замки были построены из:" +
                "Выбери букву:\n" +
                "а)Грязи;\n" +
                "б)Камня;\n" +
                "в)Дерева;\n" +
                "г)Кожи.", "в", 5, false));

        this.title = "King room";
        this.entryScoreToNextLevel = 20;
        this.history = "Хах,думал все на иностранном языке будет? \n Я человек простой,меня другие языки не интересуют," +
                "меня интересуют только оружие и все средневековое." +
                "\n Давай я тебе задам пару вопросов по средневековье,если ответишь,то пойдешь своей дорогой!";

        return new Level(this.quests, this.entryScoreToNextLevel, this.title, this.history);
    }

    public Level setLevelWitch() {
        this.quests = new ArrayList<>();
        this.quests.add(new Quest("Это кто то тут, то там\n" +
                "тускло светит по ночам?\n" +
                "Словно горстка звезд с небес,\n" +
                "опустилась ночью в лес.", "Светлячок", 10, false));
        this.quests.add(new Quest("Странный дождь порой идет:\n" +
                "сотней струй он кверху бьет.", "Фонтан", 10, false));
        this.quests.add(new Quest("Вот так чудо! Вот так диво!\n" +
                "Как сорвался он с обрыва,\n" +
                "так уже который год\n" +
                "все никак не упадет.", "Водопад", 10, false));
        this.quests.add(new Quest("Чем больше из неё берёшь, тем больше она становится.", "Яма", 10, false));
        this.quests.add(new Quest("Кто может поднять и передвинуть и коня, и слона?", "Шахматист", 5, false));
        this.quests.add(new Quest("Что делает сторож, когда у него на голове сидит воробей?", "Спит", 5, false));

        this.history = "Уууу,я вижу ты от рыцаря,он сказал," +
                "что ты хотел бы на английском языке поговорить,а нетушки!\nПомучаю я тебя,порешайка мне задачки,а то я решить что то не могу.";
        this.title = "Witch room";
        this.entryScoreToNextLevel = 60;
        return new Level(this.quests, this.entryScoreToNextLevel, this.title, this.history);
    }
}
