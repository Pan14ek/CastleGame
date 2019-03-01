package com.javadev.funtasking.makieiev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBController {
    static final String DB_URL = "jdbc:h2:C:/Users/user/Desktop/CastleGame/castlegame";
    static final String USER = "admin";
    static final String PASSWORD = "admin";

    public static void main(String[] args) {
        List<Quest> list = getQuestList();
        for (Quest quest : list) {
            System.out.println(quest.getDescription());
            System.out.println(quest.getAnswer());
            System.out.println(quest.getScore());
        }
    }

    //quests ==> level
    //Answer,Score,Description
    public static List getQuestList() {
        List<Quest> quests = new ArrayList<Quest>();
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String sql = "SELECT ANSWER,SCORE,DESCRIPTION FROM QUEST";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String answer = rs.getString("ANSWER");
                int score = rs.getInt("SCORE");
                String description = rs.getString("DESCRIPTION");
                quests.add(new Quest(answer, description, score));
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quests;
    }

    public void connectToDB() {

    }

}
