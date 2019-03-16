package com.javadev.funtasking.makieiev;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        DBController dbController = new DBController();
        List<Level> levels = dbController.getLevelList();

    }
}
