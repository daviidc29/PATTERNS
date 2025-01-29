package edu.eci.cvds.patterns.archetype;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        if (args.length != 0) {
            StringBuilder name = new StringBuilder();
            for (String arg : args) {
                name.append(arg).append(" ");
            }
            System.out.println("Hello " + name.toString().trim() + "!");
        } else {
            System.out.println("Hello World!");
        }
    }
}
