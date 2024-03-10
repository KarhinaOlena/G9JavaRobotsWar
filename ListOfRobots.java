package org.RobotsWar;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfRobots {
    public List<Robot> createRobots() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter robot's_1 name:");
        String name1 = scanner.nextLine();

        System.out.println("Enter robot's_2 name:");
        String name2 = scanner.nextLine();

        List<Robot> robots = new ArrayList<>();
        robots.add(new Robot(name1));
        robots.add(new Robot(name2));
        return robots;
    }

}
