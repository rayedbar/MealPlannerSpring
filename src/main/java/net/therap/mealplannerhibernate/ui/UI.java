package net.therap.mealplannerhibernate.ui;

import net.therap.mealplannerhibernate.app.Main;
import net.therap.mealplannerhibernate.service.DishPlanner;
import net.therap.mealplannerhibernate.service.MealPlanner;
import net.therap.mealplannerhibernate.util.Input;
import net.therap.mealplannerhibernate.util.Prompts;

/**
 * @author rayed
 * @since 10/20/16 12:07 PM
 */

public class UI {
    public static void dishUI(){
        DishPlanner dishPlanner = new DishPlanner();
        String b = "";
        while (!b.equals("b")) {
            Prompts.dishUIPrompt();

            int input = Input.getNumericInput();
            switch (input) {
                case 1:
                    dishPlanner.addDish();
                    break;
                case 2:
                    dishPlanner.viewDish();
                    break;
                case 3:
                    dishPlanner.updateDish();
                    break;
                case 4:
                    Main.mainMenu();
                    break;
                default:
                    System.out.println("Not a valid option. Please try again.");
            }
            Prompts.goBackPrompt();
            b = Input.getStringInput();
        }
        Main.mainMenu();
    }


    public static void mealUI(){
        MealPlanner mealPlanner = new MealPlanner();
        String b = "";
        while (!b.equals("b")) {
            Prompts.mealUIPrompt();
            int input = Input.getNumericInput();
            switch (input) {
                case 1:
                    mealPlanner.addMeal();
                    break;
                case 2:
                    mealPlanner.getMeal();
                    break;
                case 3:
                    mealPlanner.updateMeal();
                    break;
                case 4:
                    mealPlanner.viewMealByType();
                    break;
                case 5:
                    mealPlanner.viewMealByDay();
                    break;
                case 6:
                    Main.mainMenu();
                    break;
                default:
                    Prompts.invalidOption();
            }
            Prompts.goBackPrompt();
            b = Input.getStringInput();
        }
        Main.mainMenu();
    }

    public static void exitUI(){
        System.out.println("Exiting...");
        System.exit(0);
    }
}
