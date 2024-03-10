package org.RobotsWar;


import org.RobotsWar.ListOfRobots;
import org.RobotsWar.Robot;

import java.util.List;
import java.util.Scanner;


public class RobotsWar {
    public static void main(String[] args) {
        ListOfRobots listOfRobots = new ListOfRobots();
        List<Robot> robots = listOfRobots.createRobots();
        char printKey;
        boolean gameEnd = false;


        do {
            for (int i = 0; i < robots.size(); i++) {
                Robot robot = robots.get(i);
                if (robot.getHealth() <= 0) {
                    continue;
                }
                    System.out.println("For exit press P");
                    System.out.println("Shot at robot " + robot.getName());
                    System.out.println("Your step: press key (QWEASDZXC)");


                    Scanner scanner = new Scanner(System.in);
                    printKey = scanner.next().charAt(0);


                    if (printKey == 'p') {
                        System.out.println("Good buy!");
                        return;
                    }
                    if (robot.isHarmfulKeys(printKey) && !robot.isUsedKeys(printKey)) {
                        robot.reduceHealth(20);
                        robot.addUsedKey(printKey);
                        System.out.println("Good shot! Babah. The health of " + robot.getName() + " decreased for -20");
                    } else if (robot.isHarmfulKeys(printKey) && robot.isUsedKeys(printKey)) {
                        System.out.println("Key is not active");
                    } else if (!robot.isHarmfulKeys(printKey) && printKey != 'P') {
                        if ("QWEASDZXC".indexOf(Character.toUpperCase(printKey)) != -1) {
                            System.out.println("Key does not damage");
                        } else {
                            System.out.println("Wrong enters. Use only one key from QWEASDZXC keys");
                            robot.setInvalidInput(true);
                            i--;
                        }
                    }
                }

                System.out.println("---------");
                for (Robot robot : robots) {
                    System.out.println(robot.getName() + " , " + robot.getHealth());
                }
                System.out.println("---------");


            for (Robot robot : robots) {
                if (robot.getHealth() <= 0) {
                    Robot Looser = robot;
                    Robot Champion = robots.get(0) == Looser ? robots.get(1) : robots.get(0);
                    System.out.println("Good shot! Babah. The health of " + Looser.getName() + " decreased for -20");
                    System.out.println(Looser.getName() + " was killed");
                    System.out.println(Champion.getName() + " Win!!!");
                    System.out.println("---------");
                    System.out.println(Champion.getName() + ", " + Champion.getHealth());
                    System.out.println("---------");
                    gameEnd = true;
                }
            }

        } while (!gameEnd);


        }
    }





