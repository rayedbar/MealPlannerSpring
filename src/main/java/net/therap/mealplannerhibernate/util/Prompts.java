package net.therap.mealplannerhibernate.util;

/**
 * @author rayed
 * @since 10/17/16 1:42 PM
 */

public class Prompts {

    public static void mainMenuPrompt(){
        System.out.println("Enter appropriate number for more options:");
        System.out.println("[1] Dish");
        System.out.println("[2] Meal");
        System.out.println("[3] Exit");
    }

    public static void quitAppPrompt(){
        System.out.println("Press 'q' to quit or 'c' to continue");
    }

    public static void dishUIPrompt() {
        System.out.println("[1]Add dish");
        System.out.println("[2]View dishes");
        System.out.println("[3]Update dish");
        System.out.println("[4]Go back");
    }


    public static void mealUIPrompt(){
        System.out.println("[1]Add meal");
        System.out.println("[2]View meal");
        System.out.println("[3]Update meal");
        System.out.println("[4]View meal by type");
        System.out.println("[5]View meal by day");
        System.out.println("[6]Go back");
    }

    public static void invalidOption(){
        System.out.println("Not a valid option. Please try again.");
    }

    public static void goBackPrompt(){
        System.out.println("Press 'c' to continue or 'b' to go back");

    }
}
