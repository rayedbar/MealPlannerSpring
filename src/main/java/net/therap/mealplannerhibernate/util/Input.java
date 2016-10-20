package net.therap.mealplannerhibernate.util;

import java.util.Scanner;

/**
 * @author rayed
 * @since 10/17/16 2:24 PM
 */

public class Input {

    public static int getNumericInput(){
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
