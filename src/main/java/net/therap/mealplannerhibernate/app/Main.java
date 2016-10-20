package net.therap.mealplannerhibernate.app;

import net.therap.mealplannerhibernate.ui.UI;
import net.therap.mealplannerhibernate.util.Input;
import net.therap.mealplannerhibernate.util.Prompts;

public class Main {

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        String q = "";
        while (!q.equals("q")) {
            Prompts.mainMenuPrompt();
            int input = Input.getNumericInput();
            switch (input) {
                case 1:
                    UI.dishUI();
                    break;
                case 2:
                    UI.mealUI();
                    break;
                case 3:
                    UI.exitUI();
                default:
                    System.out.println("Not a valid option. Please try again.");
            }
            Prompts.quitAppPrompt();
            q = Input.getStringInput();
        }
        System.exit(0);
    }
}
