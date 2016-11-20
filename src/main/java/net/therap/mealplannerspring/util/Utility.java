package net.therap.mealplannerspring.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rayed
 * @since 11/20/16 12:57 PM
 */

public class Utility {

    public static List<String> getDayList(){
        List<String> dayList = new ArrayList<>();
        dayList.add("Sunday");
        dayList.add("Monday");
        dayList.add("Tuesday");
        dayList.add("Wednesday");
        dayList.add("Thursday");
        dayList.add("Friday");
        dayList.add("Saturday");
        return dayList;
    }

    public static List<String> getTypeList() {
        List<String> typeList = new ArrayList<>();
        typeList.add("Breakfast");
        typeList.add("Lunch");
        typeList.add("Dinner");
        return typeList;
    }
}
