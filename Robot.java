package org.RobotsWar;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Robot {
    private String name;
    private int health;
    private Set<Character> harmfulKeys;
    private Set<Character> usedKey;
    private boolean invalidInput;



    public Robot(String name) {
        this.name = name;
        this.health = 100;
        this.usedKey = new HashSet<>();
        this.harmfulKeys = new HashSet<>();
        this.invalidInput = false;
        for (int i = 0; i < 5; i++) {
            harmfulKeys.add(getRandomKey());
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int amount) {
        health -= amount;
    }

    public boolean isInvalidInput() {
        return invalidInput;
    }

    public void setInvalidInput(boolean invalidInput) {
        this.invalidInput = invalidInput;
    }

    private String alphabet = "QWEASDZXC";

    char getRandomKey() {
        int randIdx = new Random().nextInt(alphabet.length());
        char randChar = alphabet.charAt(randIdx);
        alphabet = alphabet.replace(String.valueOf(randChar), "");
        return randChar;
    }

    public boolean isHarmfulKeys(char key){
        char harmfulKey = Character.toUpperCase(key);
        return harmfulKeys.contains(harmfulKey);
    }

    public boolean isUsedKeys(char key){
        return usedKey.contains(key);

    }

    public void addUsedKey(char key){
        usedKey.add(key);
    }

}
